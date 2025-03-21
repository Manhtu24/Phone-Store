import React from "react";
import { Route, Routes } from "react-router";
import AdminLayout from "../adminComponent/AdminLayout";
import DashboardPage from "../adminComponent/Dashboard/DashboardPage";
const AdminRoute = () => {
  return (
    <div>
      <Routes>
        <Route path="/" element={<AdminLayout />}>
          <Route index element={<DashboardPage />} />
          <Route path="analytics" element={<h1>Analytics</h1>} />
          <Route path="dashboard" element={<DashboardPage />}/>
        </Route>
      </Routes>
    </div>
  );
};

export default AdminRoute;
