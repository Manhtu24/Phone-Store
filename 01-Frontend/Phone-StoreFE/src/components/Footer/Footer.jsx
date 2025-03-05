import React from "react";
import { assets } from "../../assets/images/images";
import Avatar from "@mui/material/Avatar";

const Footer = () => {
  return (
    <footer className="footer">
      {/* Top footer */}
      <div className=" px-4 md:px-16 lg:px-28 py-5 bg-black">
        <div className="container">
          <div className=" flex md:block lg:flex  justify-between  ">
            <div className="lg-">
              <form id="mc-form">
                <input
                  type="email"
                  aria-label="Địa chỉ email"
                  className="bg-white p-2 w-67"
                  placeholder="Nhập email nhận tin khuyến mại"
                  name="Email"
                  required
                  autoComplete="off"
                />
                <button
                  type="submit"
                  className="bg-red-600 p-2 text-white"
                  aria-label="Đăng ký nhận tin"
                  name="subscribe"
                >
                  Đăng ký
                </button>
              </form>
            </div>
            {/* Social */}
            <div className="lg-- ">
              <div className=" flex text-white items-center">
                <span className="pr-2">Kết nối với chúng tôi</span>
                <ul className=" flex gap-3 justify-center">
                  {/* Youtube */}
                  <li>
                    <a
                      href="https://www.youtube.com/@Apple"
                      title="Youtube"
                      target="_balnk"
                    >
                      <Avatar alt="Youtube" src={assets.Youtube} />
                    </a>
                  </li>
                  {/* Facebook */}
                  <li>
                    <a
                      href="https://www.facebook.com/apple"
                      title="Facebook"
                      target="_balnk"
                    >
                      <Avatar alt="Facebook" src={assets.Facebook} />
                    </a>
                  </li>
                  {/* Google */}
                  <li>
                    <a href="/" title="Google" target="_balnk">
                      <Avatar alt="Google" src={assets.Google} />
                    </a>
                  </li>
                  {/* Zalo */}
                  <li>
                    <a href="/" title="Zalo">
                      <Avatar alt="Zalo" src={assets.Zalo} />
                    </a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
      {/* medium footer */}
      <div className="bg-white-300 py-6 px-4 md:px-16 lg:px-28 ">
        {/* Chinh sach, Mua hang, Dieu khoa dich vu , Lien he */}
        <div className="grid grid-cols-2 lg:grid-cols-4 gap-8 mt-1">
          {/* COL1 */}
          <div>
            <h2 className="text-lg font-bold mb-3 text-blue-500">CHÍNH SÁCH</h2>
            {/* #00adf0 */}
            <ul>
              <li className="hover:text-red-500">
                <a
                  href="/chinh-sach-doi-tra"
                  title="Chính sách đổi trả, lên đời"
                >
                  Chính sách đổi trả, lên đời
                </a>
              </li>
              <li className="hover:text-red-500">
                <a
                  href="/chinh-sach-bao-hanh"
                  title="Chính sách bảo hành 12 tháng 1 dổi 1 "
                >
                  Chính sách bảo hành 12 tháng 1 dổi 1
                </a>
              </li>
              <li className="hover:text-red-500">
                <a href="/cam-ket-chat-luong" title="Cam kết chất lượng">
                  Cam kết chất lượng
                </a>
              </li>
              <li className="hover:text-red-500">
                <a href="/chinh-sach-bao-mat" title="Chính sách bảo mật">
                  Chính sách bảo mật
                </a>
              </li>
            </ul>
          </div>
          {/* COL2 */}
          <div>
            <h2 className="text-lg font-bold mb-3 text-blue-500">MUA HÀNG</h2>
            {/* #00adf0 */}
            <ul>
              <li className="hover:text-red-500">
                <a href="/huong-dan-mua-hang" title="Hướng dẫn mua hàng">
                  Hướng dẫn mua hàng
                </a>
              </li>
              <li className="hover:text-red-500">
                <a href="/quy-trinh-mua-hang" title="Quy trình mua hàng ">
                  Quy trình mua hàng
                </a>
              </li>
              <li className="hover:text-red-500">
                <a
                  href="/phuong-thuc-thanh-toan"
                  title="Phương thức thanh toán"
                >
                  Phương thức thanh toán
                </a>
              </li>
              <li className="hover:text-red-500">
                <a
                  href="/phuong-thuc-van-chuyen"
                  title="Phương thức vận chuyển"
                >
                  Phương thức vận chuyển
                </a>
              </li>
              <li className="hover:text-red-500">
                <a href="/phuong-thuc-tra-gop" title="Phương thức trả góp">
                  Phương thức trả góp
                </a>
              </li>
            </ul>
          </div>
          {/* COL3 */}
          <div>
            <h2 className="text-lg font-bold mb-3 text-blue-500">
              ĐIỀU KHOẢN DỊCH VỤ
            </h2>
            {/* #00adf0 */}
            <ul>
              <li className="hover:text-red-500">
                <a href="/dieu-khoan-dich-vu" title="Diều khoản dịch vụ">
                  Diều khoản dịch vụ
                </a>
              </li>
              <li className="hover:text-red-500">
                <a href="/dieu-khoan-su-dung" title="Điều khoản sử dụng">
                  Điều khoản sử dụng
                </a>
              </li>
              <li className="hover:text-red-500">
                <a href="/cam-ket-bao-mat" title="Cam kết bảo mật">
                  Cam kết bảo mật
                </a>
              </li>
              <li className="hover:text-red-500">
                <a href="/gioi-thieu" title="Giới thiệu">
                  Giới thiệu
                </a>
              </li>
              <li className="hover:text-red-500">
                <a href="/lie-he" title="Liên hệ">
                  Liên hệ
                </a>
              </li>
            </ul>
          </div>
          {/* COL4 */}
          <div>
            <h2 className="text-lg font-bold mb-3 text-blue-500">LIÊN HỆ</h2>
            {/* #00adf0 */}
            <ul>
              <li className="hover:text-red-500">
                <a
                  href="/he-thong-cua-hang-mt-store"
                  title="Cơ sở 1: 7 Nguyễn Tư Giản, Phúc Tân,Hoàn Kiếm,Hà Nội"
                >
                  Cơ sở 1: 7 Nguyễn Tư Giản, Phúc Tân,Hoàn Kiếm,Hà Nội
                  <p>0965742125</p>
                </a>
              </li>
              <li className="hover:text-red-500">
                <a
                  href="/he-thong-cua-hang-mt-store"
                  title="Cơ sở 2:288 Xã Đàn, Đống Đa, Hà Nội"
                >
                  Cơ sở 2: 288 Xã Đàn, Đống Đa, Hà Nội
                  <p>0365412323</p>
                </a>
              </li>
            </ul>
          </div>
        </div>
        {/* Tong dai ho tro , lien ket dich vu, lien ket san */}
        <div className="grid grid-cols-1 lg:grid-cols-2 xl:grid-cols-3 gap-8 mt-10 ">
          {/* COL1 */}
          <div className="col-span-1 lg:col-span-2 xl:col-span-1 ">
            <a href="/" title="Logo" className="">
              <img src={assets.logo} alt="Logo" className="w-40 h-10" />
            </a>
            <p className="text-sm">
              Hệ thống bán lẻ iPhone chính hãng với giá tốt, có trả góp, giao
              hàng nhanh miễn phí.
            </p>
            <ul>
              {/* address */}
              <li>
                <b className="text-blue-500">Địa chỉ:&nbsp;</b>
                <span>
                  Cơ sở 1: 7 Nguyễn Tư Giản, Phúc Tân,Hoàn Kiếm,Hà Nội.Cơ sở 2:
                  288 Xã Đàn, Đống Đa, Hà Nội
                </span>
              </li>
              {/* phone */}
              <li>
                <b className="text-blue-500">Điện thoại:&nbsp;</b>
                <span>0965742125</span>
              </li>
              {/* Email */}
              <li>
                <b className="text-blue-500">Email:&nbsp;</b>
                <span>suppoet@mtstore.com</span>
              </li>
            </ul>
          </div>
          {/* Support phone number */}
          <div>
            <h2 className="text-lg text-blue-500 font-bold">TỔNG ĐÀI HỖ TRỢ</h2>
            <ul>
              <li>
                <h3 className="font-bold">
                  MUA ONLINE (09:00-21-00 mỗi ngày){" "}
                </h3>
                <a href="tel:0965742125" title="0965742125">
                  0965742125
                </a>
                <p>Tất cả các ngày trong tuần (Trừ Tết Âm lịch)</p>
              </li>
              <li>
                <h3 className="font-bold">GÓP Ý & KHIẾU NẠI (09:00-21-00) </h3>
                <a href="tel:0965742125" title="0965742125">
                  0965742125
                </a>
                <p>Tất cả các ngày trong tuần (Trừ Tết Âm lịch)</p>
              </li>
            </ul>
          </div>
          {/* LINK TO and Payment method */}
          <div className="">
            <h2 className="font-bold text-lg text-blue-500">LIÊN KẾT SÀN</h2>
            <ul className="flex gap-4">
              {/* SHOPEE PICTURE */}
              <li>
                {/* SHOPEE PICTURE */}
                <a href="#" title="Shopee">
                  <Avatar alt="Shopee" src={assets.Shopee} />
                </a>
              </li>
              {/* LAZADA Picture */}
              <li>
                <a href="#" title="Lazada">
                  <Avatar alt="Lazada" src={assets.lazada} />
                </a>
              </li>
              {/* TIKI PICTURE */}
              <li>
                <a href="#" title="Tiki">
                  <Avatar alt="Tiki" src={assets.Tiki} />
                </a>
              </li>
              {/* Sendo picture */}
              <li>
                <a href="#" title="Sendo">
                  <Avatar alt="Sendo" src={assets.Sendo} />
                </a>
              </li>
            </ul>
            <h2 className="font-bold text-lg text-blue-500">
              HÌNH THỨC THANH TOÁN{" "}
            </h2>
            <ul className="flex gap-4 ">
              <li>
                <a href="#" title="Tiền mặt">
                  <Avatar alt="Tiền mặt" src={assets.cash} />
                </a>
              </li>
              <li>
                <a href="#" title="Chuyển khoản">
                  <Avatar alt="Chuyển khoản" src={assets.transfer} />
                </a>
              </li>
              <li>
                <a href="#" title="Visa">
                  <Avatar alt="Visa" src={assets.visa} />
                </a>
              </li>
            </ul>
          </div>
        </div>
      </div>
      {/* buttom footer */}
      <div className="bg-blue-400 mt-5">
        <div className="text-center">
          <p className="text-white">
            Bản quyển thuộc về <span className="text-red-600">BMT</span>.Cung
            cấp bởi <sapn className="text-red-500">BMT</sapn>
          </p>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
