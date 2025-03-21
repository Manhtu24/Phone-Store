import React from "react";
import { Route, Routes } from "react-router";
import Home from "../components/Home/Home";
import Layout from "../components/Layout/Layout";
import Login from "../components/Authentication/Login";
import Register from "../components/Authentication/Register";
import Authentication from "../components/Authentication/Authentication";
import ReturnPolicy from "../pages/ReturnPolicy";
import WarrantyPolicy from "../pages/WarrabtyPolicy";
import QualityCommit from "../pages/QualityCommit";
import Introduce from "../pages/Introduce";

const CustomerRoute = () => {
  return (
    <div>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Home />} />
          <Route path="home" element={<Home />} />
          <Route path="chinh-sach-doi-tra" element={<ReturnPolicy />} />
          <Route path="chinh-sach-bao-hanh" element={<WarrantyPolicy />} />
          <Route path="cam-ket-chat-luong" element={<QualityCommit />} />
          <Route path="gioi-thieu" element={<Introduce />} />
        </Route>
        <Route path="/account" element={<Layout />}>
          <Route path="login" element={<Authentication />} />
          <Route path="register" element={<Authentication />} />
        </Route>
      </Routes>
    </div>
  );
};

export default CustomerRoute;
