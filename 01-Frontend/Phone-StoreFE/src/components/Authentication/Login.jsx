import React from "react";
import { Link } from "react-router";

const Login = () => {
  return (
    <div>
      <form action="" className="flex flex-col items-center">
        <input
          type="email"
          name="email"
          placeholder="Email"
          className="mb-3 p-2 w-[90%]  border rounded focus:outline-none focus:ring-2 focus:ring-blue-400 "
          required
        />
        <input
          type="password"
          name="password"
          placeholder="Mật khẩu"
          className="mb-3 w-[90%]  p-2 border rounded focus:outline-none focus:ring-2 focus:ring-blue-400 "
          required
        />
        <button
          type="submit"
          className="w-[90%] bg-blue-500 text-white py-2 rounded hover:bg-red-600 transition"
        >
          Đăng nhập
        </button>
      </form>

      <div className="pt-4">
        <p
          className="text-center hover:text-red-500 cursor-pointer pb-5"
          onClick
        >
          Quên mật khẩu?
        </p>
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
          >
            Lấy lại mật khẩu
          </button>
        </form>
      </div>
    </div>
  );
};

export default Login;
