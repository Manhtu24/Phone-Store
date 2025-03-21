import React, { useState } from "react";
import { Link } from "react-router";
import { assets } from "../../assets/images/images";
import MenuIcon from "@mui/icons-material/Menu";
import { IconButton } from "@mui/material";
import SearchIcon from "@mui/icons-material/Search";
import LocalPhoneIcon from "@mui/icons-material/LocalPhone";
import PlaceIcon from "@mui/icons-material/Place";
import LocalShippingIcon from "@mui/icons-material/LocalShipping";
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";
import Badge from "@mui/material/Badge";
import AccountCircleIcon from "@mui/icons-material/AccountCircle";
import SearchBar from "./SearchBar";
const Header = () => {
  const [isActive, setActive] = useState(false);
  const [open, setOpen] = useState(false);

  const handleActive = () => {
    setActive(!isActive);
  };
  return (
    <div className="bg-black cursor-pointer">
      <div className=" flex items-center mx-35 md:mx-30 lg:mx-25 xl:mx-20 text-white gap-3 justify-center">
        <Link to={"/"} title="Logo">
          <picture>
            <img
              src={assets.logo}
              alt="MT Store"
              className="md:max-w-18 lg:max-w-35 md:h-7 lg:h-12 object-contain"
            />
          </picture>
        </Link>

        <div
          className={`hidden lg:flex justify-center items-center  bg-neutral-800 px-4 py-1 ${
            isActive ? "bg-red-600" : ""
          }`}
          onClick={handleActive}
        >
          <div className="flex-1">
            <IconButton>
              <MenuIcon style={{ color: "white" }} />
            </IconButton>
          </div>
          <span className="whitespace-nowrap text-sm">Danh mục</span>
        </div>
        {/* SEARCH */}
        <div className="">
          <SearchBar />
        </div>

        <div className="hidden lg:gap-5 lg:flex ">
          {/* HOTLINE */}
          <div className="hidden xl:flex xl:items-center  ">
            <div className="icon">
              <IconButton>
                <LocalPhoneIcon style={{ color: "white" }} />
              </IconButton>
            </div>
            <div className="content">
              <a
                href="tel:0965742125"
                title="0965742125"
                className=" hover:text-red-500 flex flex-col min-w-[60px] max-w-[120px]"
              >
                <span className="whitespace-nowrap text-small"> Hotline</span>
                <span className="whitespace-nowrap text-small">
                  {" "}
                  0813600999
                </span>
              </a>
            </div>
          </div>
          {/* Store system */}
          <div className=" flex items-center  ">
            <div className="icon">
              <IconButton>
                <PlaceIcon style={{ color: "white" }} />
              </IconButton>
            </div>
            <div className="content">
              <Link
                href="/he-thong-cua-hang-mt-store"
                title="Hệ thống cửa hàng"
                className=" hover:text-red-500 flex flex-col min-w-[50px] max-w-[120px] "
              >
                <span className="whitespace-nowrap text-small"> Hệ thống</span>
                <span className="whitespace-nowrap text-small"> cửa hàng</span>
              </Link>
            </div>
          </div>
          {/* Searching order  */}
          <div className=" flex items-center">
            <div className="icon">
              <IconButton>
                <LocalShippingIcon style={{ color: "white" }} />
              </IconButton>
            </div>
            <div className="content hover:text-red-600">
              <Link
                href={``}
                title="Tra cứu đơn hàng"
                className=" hover:text-red-500 flex flex-col min-w-[60px] max-w-[120px] "
              >
                <span className="whitespace-nowrap text-small"> Tra cứu</span>
                <span className="whitespace-nowrap text-small"> đơn hàng</span>
              </Link>
            </div>
          </div>
          {/* Cart  */}
          <div className=" flex  items-center">
            <div className="icon">
              <IconButton>
                <Badge badgeContent={1} color="primary">
                  <ShoppingCartIcon style={{ color: "white" }} />
                </Badge>
              </IconButton>
            </div>
            <div className="content hover:text-red-600">
              <Link to="/cart" title="Giở hàng">
                <span className="whitespace-nowrap text-small"> Giỏ hàng</span>
              </Link>
            </div>
          </div>
          {/* Authentication and Information  */}
          <div
            className=" flex items-center relative flex-col hover:bg-red-600 bg-neutral-800 "
            onClick={() => setOpen(true)}
            onMouseLeave={() => setOpen(false)}
            onMouseEnter={() => setOpen(true)}
          >
            <div className="">
              <IconButton>
                <AccountCircleIcon style={{ color: "white" }} />
              </IconButton>
            </div>
            <div className="content">
              <span className="whitespace-nowrap text-small">Thông tin</span>
            </div>
            <div className={`${open ? "block" : "hidden"}`}>
              <ul className=" flex flex-col justify-evenly absolute  z-1 bg-white top-15 right-0.5 w-50 h-20 ">
                <li className="text-gray-600 ">
                  <Link
                    to="/account/login"
                    title="Đăng nhập"
                    className="flex items-center hover:text-blue-600"
                  >
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="16"
                      height="16"
                      fill="currentColor"
                      className="mr-1"
                      viewBox="0 0 16 16"
                    >
                      <path
                        fillRule="evenodd"
                        d="M6 3.5a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-2a.5.5 0 0 0-1 0v2A1.5 1.5 0 0 0 6.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-8A1.5 1.5 0 0 0 5 3.5v2a.5.5 0 0 0 1 0v-2z"
                      ></path>
                      <path
                        fillRule="evenodd"
                        d="M11.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H1.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"
                      ></path>
                    </svg>
                    <span className="text-small">Đăng nhập</span>
                  </Link>
                </li>
                <li className="text-gray-600 pt-1.5">
                  <Link
                    to="/account/register"
                    title="Đăng ký"
                    className="flex items-center hover:text-blue-600"
                  >
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="16"
                      height="16"
                      fill="currentColor"
                      className="mr-1"
                      viewBox="0 0 16 16"
                    >
                      <path d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H1s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C9.516 10.68 8.289 10 6 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"></path>
                      <path
                        fillRule="evenodd"
                        d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"
                      ></path>
                    </svg>
                    <span className="text-small"> Đăng ký</span>
                  </Link>
                </li>
              </ul>
              {/* when singin or register successfully */}
              <ul></ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Header;
