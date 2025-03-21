import React, { useState } from "react";
import { useDispatch } from "react-redux";
import { useNavigate } from "react-router";
import { registerUser } from "../State/Authentication/Action";

const Register = () => {
  const [formData, setFormData] = useState({
    fullName: "",
    email: "",
    phoneNumber: "",
    password: "",
    confirmPassword: "",
  });
  const [errors, setErrors] = useState({});
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const handleOnChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const validateForm = () => {
    let tempErrors = {};
    if (!formData.fullName.trim()) {
      tempErrors.fullName = "Full name is required and cannot be just spaces";
    }
    if (!formData.password.trim() || formData.password.length < 7) {
      tempErrors.password =
        "Password greater than 7 characters and cannot be just spaces ";
    }
    if (formData.password !== formData.confirmPassword) {
      tempErrors.confirmPassword = "Password do not match";
    }
    setErrors(tempErrors);
    return Object.keys(tempErrors).length === 0;
  };

  const handleOnSubmit = (e) => {
    e.preventDefault();
    const { confirmPassword, ...userData } = formData;
    if (validateForm()) {
      dispatch(registerUser({ userData, navigate }));
    }
  };
  return (
    <div>
      <form onSubmit={handleOnSubmit} className="flex flex-col items-center">
        <input
          type="text"
          name="fullName"
          value={formData.fullName}
          onChange={handleOnChange}
          placeholder="Họ tên"
          className="mb-3 p-2 w-[90%]  border rounded focus:outline-none focus:ring-2 focus:ring-blue-400 "
          required
        />
        {errors.fullName && (
          <p className="text-red-500 text-sm mt-1 animate-bounce">
            {errors.fullName}
          </p>
        )}
        <input
          type="email"
          name="email"
          value={formData.email}
          onChange={handleOnChange}
          placeholder="Email"
          className="mb-3 p-2 w-[90%]  border rounded focus:outline-none focus:ring-2 focus:ring-blue-400 "
          required
        />
        <input
          type="tel"
          name="phoneNumber"
          value={formData.phoneNumber}
          onChange={handleOnChange}
          placeholder="Số điện thoại"
          className="mb-3 p-2 w-[90%]  border rounded focus:outline-none focus:ring-2 focus:ring-blue-400 "
          required
        />
        <input
          type="password"
          name="password"
          value={formData.password}
          onChange={handleOnChange}
          placeholder="Mật khẩu"
          className="mb-3 w-[90%]  p-2 border rounded focus:outline-none focus:ring-2 focus:ring-blue-400 "
          required
        />

        {errors.password && (
          <p className="text-red-500 text-sm mt-1 animate-bounce">
            {errors.password}
          </p>
        )}
        <input
          type="password"
          name="confirmPassword"
          value={formData.comfirmPassword}
          onChange={handleOnChange}
          placeholder="Nhập lại mật khẩu"
          className="mb-3 w-[90%]  p-2 border rounded focus:outline-none focus:ring-2 focus:ring-blue-400 "
          required
        />
        {errors.confirmPassword && (
          <p className="text-red-500 text-sm mt-1 animate-bounce">
            {errors.confirmPassword}
          </p>
        )}
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
