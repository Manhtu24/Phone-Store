import React, { useState } from "react";
import { Link, useNavigate } from "react-router";
import { useDispatch } from "react-redux";
import { loginUser } from "../State/Authentication/Action";
import { LOGOUT } from "../State/Authentication/ActionType";

const Login = () => {
  const dispatch = useDispatch();
  const [isForgotPassword, setForgotPassword] = useState(false);
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const values = {
    email: email,
    password: password,
  };
  const navigate = useNavigate();
  const handleOnSubmit = async (e) => {
    e.preventDefault();
    dispatch(loginUser({ userData: values, navigate }));
  };
  return (
    <div>
      <form onSubmit={handleOnSubmit} className="flex flex-col items-center">
        <input
          type="email"
          name="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          placeholder="Email"
          className="mb-3 p-2 w-[90%]  border rounded focus:outline-none focus:ring-2 focus:ring-blue-400 "
          required
        />
        <input
          type="password"
          name="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          placeholder="Mật khẩu"
          className="mb-3 w-[90%]  p-2 border rounded focus:outline-none focus:ring-2 focus:ring-blue-400 "
          required
        />
        <button
          type="submit"
          className="w-[90%] bg-blue-500 text-white py-2 rounded hover:bg-red-600 "
        >
          Đăng nhập
        </button>
      </form>
      <div className="pt-4">
        <p
          className="text-center hover:text-red-500 cursor-pointer "
          onClick={() => {
            setForgotPassword(!isForgotPassword);
          }}
        >
          Quên mật khẩu?
        </p>
      </div>

      <div
        className={`overflow-hidden transition-all duration-700 ${
          isForgotPassword
            ? "max-h-[200px] opacity-100 mt-3"
            : "max-h-0 opacity-0"
        }`}
      >
        <form action="" className="flex flex-col items-center">
          <input
            type="email"
            name="email"
            placeholder="Email"
            className="mb-3 w-[90%]  p-2 border rounded focus:outline-none focus:ring-2 focus:ring-blue-400 "
            required
          />
          <button
            type="submit"
            className="w-[90%] bg-blue-500 text-white py-2 rounded hover:bg-red-600 transition"
            onClick={() => setForgotPassword(false)}
          >
            Lấy lại mật khẩu
          </button>
        </form>
      </div>
    </div>
  );
};

export default Login;
