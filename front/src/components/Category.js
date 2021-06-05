import React, { useContext, useEffect } from "react";
import Store from "./Store";
import C from "../utils/constants";
import List from "./List";
import Form from "./Form";

const HOST_API = C.HOST_API;

const Category = (props) => {
  const { dispatch } = useContext(Store);

  const onDelete = (event, id) => {
    event.preventDefault();
    fetch(HOST_API + "/categories/delete/" + id, {
      method: "DELETE",
    }).then(() => {
      dispatch({ type: "delete-category", id });
    });
  };

  const data = props.categoryData;
  return (
    <li>
      <div>
        <h3>{data.categoryName}</h3>
        <button onClick={(event) => onDelete(event, data.id)}>
          EliminarCategoria
        </button>
      </div>
      <div>
        <Form id={data.id} />
      </div>
      <div>
        <List todos={data.toDos} />
      </div>
    </li>
  );
};
export default Category;
