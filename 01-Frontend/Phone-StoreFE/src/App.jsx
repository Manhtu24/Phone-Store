import { useState } from "react";
import "./App.css";
import React from "react";
import Routers from "./routers/Routers";
import { ThemeProvider } from "./Theme/theme-context";

function App() {
  return (
    <ThemeProvider storageKey="theme">
      <Routers />
    </ThemeProvider>
  );
}

export default App;
