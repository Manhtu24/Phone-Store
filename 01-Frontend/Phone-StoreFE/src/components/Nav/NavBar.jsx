import React from "react";
import { Link } from "react-router";
import { assets } from "../../assets/images/images";
import Header from "./Header";

const NavBar = () => {
  return (
    <header>
      <Header />
      <div className="header-menu">
        <div className="container">
          <div className="header-menu-des">
            <nav className="header-nav px-4 md:px-16 lg:px-28 py-2 bg-gray-200 ">
              <ul className=" flex gap-6">
                <li className="block  xl:hidden ">
                  <span>Menu chính</span>
                </li>
                <li className="nav-item active">
                  <a href="/" title="Trang chủ" className="hover:text-blue-500">
                    Trang chủ
                  </a>
                </li>
                <li className="nav-item">
                  <a
                    href="/dien-thoai"
                    title="Điện thoại"
                    className="hover:text-blue-500"
                  >
                    Điện thoại
                  </a>
                </li>
                <li className="nav-item">
                  <a
                    href="/phu-kien"
                    title="Phụ kiện"
                    className="hover:text-blue-500"
                  >
                    Phụ kiện
                  </a>
                </li>
                <li className="nav-item">
                  <a
                    href="/linh-kien"
                    title="Linh Kiện"
                    className="hover:text-blue-500"
                  >
                    Linh kiện
                  </a>
                </li>
                <li className="nav-item">
                  <a
                    href="/chinh-sach-bao-hanh"
                    title="Chính sách bảo hành"
                    className="hover:text-blue-500"
                  >
                    {" "}
                    Chính sách bảo hành
                  </a>
                </li>
                <li className="nav-item">
                  <a
                    href="/chinh-sach-doi-tra"
                    title="Chính sách đổi trả, lên đời"
                    className="hover:text-blue-500"
                  >
                    Chính sách đổi trả lên đời
                  </a>
                </li>
                <li className="nav-item">
                  <a
                    href="/lien-he"
                    title="Liên hệ"
                    className="hover:text-blue-500"
                  >
                    Liên hệ
                  </a>
                </li>
                <li className="nav-item">
                  <a
                    href="https://www.facebook.com/apple"
                    title="Facebook Page"
                    className="hover:text-blue-500"
                    target="_blank"
                  >
                    Facebook Page
                  </a>
                </li>
                <li className="nav-item">
                  <a
                    href="https://www.tiktok.com/@apple"
                    title="Tiktok"
                    className="hover:text-blue-500"
                    target="_blank"
                  >
                    Tiktok
                  </a>
                </li>
                <li className="nav-item">
                  <a
                    href="https://www.youtube.com/@Apple"
                    title="Youtube"
                    className="hover:text-blue-500"
                    target="_blank"
                  >
                    Youtube
                  </a>
                </li>
              </ul>
            </nav>
          </div>
        </div>
      </div>
    </header>
  );
};

export default NavBar;
