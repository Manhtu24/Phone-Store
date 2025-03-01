import React from "react";
import { Routes, Route } from "react-router";
import AdminRoute from "./AdminRoute";
import CustomerRoute from "./CustomerRoute";

const Routers = () => {
  return (
    <div>
      <Routes>
        <Route path="/*" element={<CustomerRoute />} />
        <Route path="/admin/*" element={<AdminRoute />} />
      </Routes>
    </div>
  );
};

export default Routers;
