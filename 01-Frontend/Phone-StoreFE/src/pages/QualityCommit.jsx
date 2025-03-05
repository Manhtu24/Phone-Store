import React from "react";
import StaticTemplate from "./StaticTemplate";
import { Link } from "react-router";
const QualityCommit = () => {
  return (
    <StaticTemplate>
      <div>
        <div className="page-title">
          <h1>Cam kết chất lượng</h1>
        </div>
        <div className="page-content">
          <p>
            <strong>MT-STORE-UY TÍN LÀ TRÊN HẾT</strong>
          </p>
          <p>
            <span>- Cam kết máy bán ra đúng như mô tả;</span>
          </p>
          <p>
            <span>- Cam kết bảo hành uy tín, nghiêm chỉnh;</span>
          </p>
          <p>
            <span>
              - Cam kết đem lại sự hài lòng tuyệt đối về giá cũng như dịch vụ
              cho khách hàng;
            </span>
          </p>
          <p>
            <strong>CHẾ ĐỘ BẢO HÀNH ƯU VIỆT</strong>
          </p>
          <p>
            <span>
              - Bảo hành 12 tháng, đổi mới ngay trong suốt thời gian bảo hành
              nếu phát sinh lỗi NSX đối với máy mới
            </span>
          </p>
          <p>
            <span>
              - Bảo hành 12 tháng, đổi mới ngay trong suốt thời gian bảo hành
              nếu phát sinh lỗi NSX đối với máy like new iPhone và iPad.{" "}
            </span>
          </p>
          <p>
            <span>- Bảo hành 12 tháng đối với máy các dòng máy khác.</span>
          </p>
          <p>
            <span>
              - Cam kết với máy mới: Fullbox chưa active, phụ kiện nguyên bản
            </span>
          </p>
          <p>
            <span>
              - Cam kết với máy like new: Mới 99%, còn nguyên zin chính hãng
              Apple, không icloud. Bao test cả các bác thợ, bao bung máy check
              main, màn nếu có nhu cầu.
            </span>
          </p>
          <p>
            <span>
              - Khuyến mại kèm cáp Zin + dán cường lực màn hình + ốp chống sốc
              với mọi máy bán ra.{" "}
            </span>
          </p>
          <p>
            <span>- Hỗ trợ cài đặt, lập tài khoản itunes</span>
          </p>
          <p>
            <strong>
              <Link to={"/home"}>
                <span className="hover:text-red-500">MT STORE</span>-UY TÍN LÀ
                SỨC MẠNH
              </Link>
            </strong>
          </p>
          <p>
            <span>Chi nhánh Online: 0813.600.999</span>
          </p>
          <p>
            <span>CS1: 7 Nguyễn Tư Giản, Phúc Tân,Hoàn Kiếm,Hà Nội</span>
          </p>
          <p>
            <span>CS2: 288 Xã Đàn, Đống Đa, Hà Nội</span>
          </p>
        </div>
      </div>
    </StaticTemplate>
  );
};

export default QualityCommit;
