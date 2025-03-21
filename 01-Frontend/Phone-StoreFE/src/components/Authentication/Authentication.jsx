import React, { useEffect, useState } from "react";
import { useLocation, useNavigate } from "react-router";
import FacebookIcon from "@mui/icons-material/Facebook";
import GoogleIcon from "@mui/icons-material/Google";
import { IconButton } from "@mui/material";
import RemoveShoppingCartIcon from "@mui/icons-material/RemoveShoppingCart";
import Login from "./Login";
import Register from "./Register";

const Authentication = () => {
  const [isLoginBtn, setLoginBtn] = useState(true);

  const location = useLocation();
  const navigate = useNavigate();
  useEffect(() => {
    const path = location.pathname.slice(9);
    if (path === "register") {
      setLoginBtn(false);
    } else setLoginBtn(true);
  }, [location.pathname]);
  return (
    <div className="bg-gray-300 pt-2">
      <div className="px-4 md:px-16 lg:px-28">
        <div className="w-[75%] md:w-[55%] lg:w-[45%] xl:w-[35%] mx-auto bg-white">
          <div className="p-2 flex">
            <button
              className={`flex-1 py-2 font-semibold hover:text-blue-500  ${
                isLoginBtn
                  ? "text-blue-500 border-b-2 border-blue-500"
                  : "text-gray-500"
              }`}
              onClick={() => {
                setLoginBtn(true);
                navigate("/account/login");
              }}
            >
              ĐĂNG NHẬP
            </button>
            <button
              className={`flex-1 py-2 font-semibold hover:text-blue-500 ${
                !isLoginBtn
                  ? "text-blue-500 border-b-2 border-blue-500"
                  : "text-gray-500"
              }`}
              onClick={() => {
                setLoginBtn(false);
                navigate("/account/register");
              }}
            >
              ĐĂNG KÝ
            </button>
          </div>
          {isLoginBtn ? (
            <h1 className="text-center mb-3">ĐĂNG NHẬP</h1>
          ) : (
            <h1 className="text-center mb-3">ĐĂNG KÝ</h1>
          )}
          {isLoginBtn ? <Login /> : <Register />}
          <div className="p-3">
            <p className="text-center">Hay đăng nhập bằng</p>
            <div className="flex flex-col md:flex-row   justify-center pb-2 pt-2 gap-2 mx-2">
              <a
                href="#"
                title="Facebook"
                className="flex flex-1 justify-center items-center bg-blue-500 hover:bg-blue-700 "
              >
                <IconButton>
                  <FacebookIcon />
                </IconButton>
                <span className="text-white">Facebook</span>
              </a>
              <a
                href="#"
                title="Google"
                className="flex flex-1 justify-center items-center bg-red-400 hover:bg-red-600 "
              >
                <IconButton>
                  <GoogleIcon style={{ color: "white" }} />
                </IconButton>
                <span className="text-white">Google</span>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Authentication;
