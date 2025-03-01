import React from "react";
import { Route, Routes } from "react-router";
import Home from "../components/Home/Home";
import Layout from "../components/Layout/Layout";
import Login from "../components/Authentication/Login";
import Register from "../components/Authentication/Register";
import Authentication from "../components/Authentication/Authentication";

const CustomerRoute = () => {
  return (
    <div>
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Home />} />
        </Route>

        <Route path="/account" element={<Layout />}>
          <Route path="login" element={<Authentication />} />
          <Route path="register" element={<Authentication />} />
        </Route>
      </Routes>
    </div>
  );
};

/*
if always include header anđ footer
        <Route path="/" element={<Layout />}>
          <Route index element={<HomePage />} />
          <Route path="products" element={<ProductPage />} />
          <Route path="contact" element={<ContactPage />} />
        </Route>
*/

export default CustomerRoute;
