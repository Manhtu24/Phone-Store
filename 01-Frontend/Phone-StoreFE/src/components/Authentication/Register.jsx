import React from "react";

const Register = () => {
  return (
    <div>
      <form action="" className="flex flex-col items-center">
        <input
          type="text"
          name="sirname"
          placeholder="Họ"
          className="mb-3 p-2 w-[90%]  border rounded focus:outline-none focus:ring-2 focus:ring-blue-400 "
          required
        />
        <input
          type="text"
          name="name"
          placeholder="Tên"
          className="mb-3 p-2 w-[90%]  border rounded focus:outline-none focus:ring-2 focus:ring-blue-400 "
          required
        />
        <input
          type="email"
          name="email"
          placeholder="Email"
          className="mb-3 p-2 w-[90%]  border rounded focus:outline-none focus:ring-2 focus:ring-blue-400 "
          required
        />
        <input
          type="number"
          name="phonenumber"
          placeholder="Số điện thoại"
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
        <input
          type="password"
          name="password"
          placeholder="Nhập lại mật khẩu"
          className="mb-3 w-[90%]  p-2 border rounded focus:outline-none focus:ring-2 focus:ring-blue-400 "
          required
        />

        <button
          type="submit"
          className="w-[90%] bg-blue-500 text-white py-2 rounded hover:bg-red-600 transition"
        >
          Đăng ký
        </button>
      </form>
    </div>
  );
};

export default Register;
