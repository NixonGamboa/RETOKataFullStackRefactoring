import React, { useContext, useEffect } from "react";
import Store from "./Store";
import C from "../utils/constants";
import FormCategory from "./FormCategory";
import Category from "./Category";
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
        dispatch({ type: "update-categories", categories });
      });
  }, [dispatch]);

  return (
    <div>
      <h2 style={{ backgroundColor: "lightblue" }}>MIS TAREAS...</h2>
      <FormCategory />

      {categoryList.map((category) => {
        return <Category key={category.id} categoryData={category} />;
      })}
    </div>
  );
};
export default ListCategories;
