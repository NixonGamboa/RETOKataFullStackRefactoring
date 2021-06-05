import React, { useRef, useState, useContext } from "react";
import Store from "./Store";
import C from "../utils/constants";
const HOST_API = C.HOST_API;

const FormCategory = () => {
  const formRef = useRef(null);
  const {
    dispatch,
    state: { todo },
  } = useContext(Store);
  const item = todo.item;
  const [state, setState] = useState(item);

  const onAdd = (event) => {
    event.preventDefault();

    const request = {
      categoryName: state.name.toUpperCase(),
      id: null,
      toDos: [],
    };

    fetch(HOST_API + "/categories/save", {
      method: "POST",
      body: JSON.stringify(request),
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((category) => {
        dispatch({ type: "add-category", item: category });
        setState({ name: "" });
        formRef.current.reset();
      });
  };

  return (
    <form ref={formRef}>
      <input
        type="text"
        name="name"
        placeholder="Tu nueva categoria"
        defaultValue={item.name}
        onChange={(event) => {
          setState({ ...state, name: event.target.value });
        }}
      ></input>
      {!item.id && <button onClick={onAdd}>Crear</button>}
    </form>
  );
};

export default FormCategory;
