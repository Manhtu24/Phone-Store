import React from "react";
import { useLocation } from "react-router";

const Breadcrumbs = () => {
  const location = useLocation();
  const paths = location.pathname.split("/").filter((path) => path);
  if (location.pathname === "/home") return null;
  

  return <div></div>;
};

export default Breadcrumbs;
