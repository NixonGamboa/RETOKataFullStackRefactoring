import React, { useContext } from "react";
import Store from "./Store";
import C from "../utils/constants";
import List from "./List";
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
  console.log("cada categoria " + data);
  return (
    <div>
      <table>
        <tr>
          <td>{data.id}</td>
          <td>{data.categoryName}</td>
          <td>
            <button onClick={() => onDelete(data.id)}>Eliminar</button>
          </td>
        </tr>
      </table>
    </div>
  );
};
export default Category;
