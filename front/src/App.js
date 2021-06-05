import React from "react";
import { StoreProvider } from "./components/Store";
import ListCategories from "./components/ListCategories";

function App() {
  return (
    <StoreProvider>
      <ListCategories />
    </StoreProvider>
  );
}

export default App;
