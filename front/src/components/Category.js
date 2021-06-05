import React, { useContext, useEffect } from "react";
import Store from "./Store";
import C from "../utils/constants";
import List from "./List";
import Form from "./Form";

const HOST_API = C.HOST_API;

const Category = (props) => {
  const { dispatch } = useContext(Store);

  const onDelete = (id) => {
    fetch(HOST_API + "/" + id + "/todo", {
      method: "DELETE",
    }).then((list) => {
      dispatch({ type: "delete-item", id });
    });
  };

  const data = props.categoryData;
  return (
    <li>
      <div>
        <h3>{data.categoryName}</h3>
        <button onClick={() => onDelete(data.id)}>EliminarCategoria</button>
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
