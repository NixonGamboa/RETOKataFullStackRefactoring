import React, { useContext, useEffect } from "react";
import Store from "./Store";
import C from "../utils/constants";
import List from "./List";
const HOST_API = C.HOST_API;

const ListCategories = () => {
  const {
    dispatch,
    state: { todo },
  } = useContext(Store);
  const categoryList = todo.list;

  useEffect(() => {
    fetch(HOST_API + "/categories")
      .then((response) => response.json())
      .then((categories) => {
        console.log("Lo que llega en el Json");
        console.log(categories);
        dispatch({ type: "update-categories", categories });
      });
  }, [dispatch]);

  const onDelete = (id) => {
    fetch(HOST_API + "/" + id + "/todo", {
      method: "DELETE",
    }).then((list) => {
      dispatch({ type: "delete-item", id });
    });
  };

  return (
    <div>
      <table>
        <thead>
          <tr>
            <td>ID</td>
            <td>Tarea</td>
            <td>¿Completado?</td>
          </tr>
        </thead>
        <tbody>
          {
            ((console.log("Estado"),
            console.log(todo),
            console.log("CategoryList"),
            console.log(categoryList)),
            categoryList.map((category) => {
              return (
                <tr key={category.categoryId}>
                  <td>{category.categoryId}</td>
                  <td>{category.categoryName}</td>
                  <td>
                    <button onClick={() => onDelete(category.categoryId)}>
                      Eliminar
                    </button>
                  </td>
                </tr>
              );
            }))
          }
        </tbody>
      </table>
    </div>
  );
};
export default ListCategories;
