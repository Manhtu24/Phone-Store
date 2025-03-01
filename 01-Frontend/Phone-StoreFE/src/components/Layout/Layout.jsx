import React from "react";
import NavBar from "../Nav/NavBar";
import { Outlet } from "react-router";
import Footer from "../Footer/Footer";

const Layout = () => {
  return (
    <>
      <NavBar />
      <main className="bg-auto">
        <Outlet />
      </main>
      <Footer />
    </>
  );
};

export default Layout;
