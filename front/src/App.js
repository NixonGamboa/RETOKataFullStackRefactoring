import React from "react";
import { StoreProvider } from "./components/Store";
import Form from "./components/Form";
import ListCategories from "./components/ListCategories";

function App() {
  return (
    <StoreProvider>
      <ListCategories />
    </StoreProvider>
  );
}

export default App;
