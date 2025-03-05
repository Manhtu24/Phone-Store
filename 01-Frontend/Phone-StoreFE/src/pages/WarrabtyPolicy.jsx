import React from "react";
import StaticTemplate from "./StaticTemplate";
import { assets } from "../assets/images/images";

const WarrantyPolicy = () => {
  return (
    <StaticTemplate>
      <div className="page-title">
        <h1>Chính sách bảo hành 12 tháng 1 đổi 1</h1>
      </div>
      <div className="img">
        <img src={assets.warranty} alt="Chính sách bảo hảnh" loading="lazy" />
      </div>
      <div className="page-content">
        <p>
          <span>
            <strong>CHÍNH SÁCH BẢO HÀNH</strong>
          </span>
        </p>
        <p>
          <span>
            💥 LỖI DO NHÀ SẢN XUẤT - 12 THÁNG 1 ĐỔI 1 - MUA GÌ ĐỔI NẤY
          </span>
        </p>
        <p>
          <span>
            ➖Tất cả máy bán ra không bao gồm máy thanh lý được bảo hành 12
            tháng lỗi 1 đổi 1 bao gồm cả máy New và Likenew:
          </span>
        </p>
        <p>
          <span>- Mua Newseal đổi Newseal</span>
        </p>
        <p>
          <span>-Mua New trần đổi New trần </span>
        </p>
        <p>
          <span>- Mua New TBH đổi New TBH</span>
        </p>
        <p>
          <span>-Mua Sạc ít đổi Sạc ít </span>
        </p>
        <p>
          <span>-Mua LikeNew đổi LikeNew ...</span>
        </p>
        <p>➖Lưu ý :</p>
        <p>
          <span>
            - Trường hợp không có máy đổi tương đương thì khách hàng có thể lên
            đời (bù tiền chênh lệch) hoặc xuống đời (được trừ tiền chênh lệch)
            và hoàn toàn không mất thêm phí.
          </span>
        </p>
        <p>
          <span>
            - Hoặc được hoàn 100% tiền theo giá Web tại thời điểm bảo hành ( Lưu
            ý: Khách vui lòng đợi tối đa 15 ngày. Sau 15 ngày không có máy đổi
            sẽ hoàn đủ tiền theo giá web tại thời điểm bảo hành){" "}
          </span>
        </p>
        <p>
          <span>
            *Đối với linh kiện Pin EU bảo hành 6 tháng và phụ kiện bảo hành 1
            năm, không áp dụng đổi trả ( Pin dưới 80% thay miễn phí trong thời
            gian bảo hành ){" "}
          </span>
        </p>
        <p>
          💥 LỖI DO NGƯỜI DÙNG - SỬA CHỮA MIỄN PHÍ KHÔNG GIỚI HẠN TRONG 1 NĂM !
        </p>
        <p>
          <span>
            Cụ thể các lỗi như: RƠI VỠ - VÀO NƯỚC, trầy xước mạnh, chân sạc rỉ
            sét hoặc sụp mạch, cháy cảm biến camera do tia laser..vvv .
          </span>
        </p>
        <p>
          <span>
            ➖Sửa chữa MIỄN PHÍ tất cả các lỗi phần cứng ... riêng màn hình HỖ
            TRỢ 50% giá gốc nếu không sửa được và cần phải thay linh kiện mới.{" "}
          </span>
        </p>
        <p>
          <span>
            ➖Trường hợp khách hàng có nhu cầu lên đời Hoàng Kiên sẽ thanh lý
            bán hộ chuyển khoản đủ 100% tiền ( khi số tiền bán hộ cao hơn 50%
            giá Web )
          </span>
        </p>
        <p>
          <span>
            ➖ Trường hợp máy vỡ nát hoặc lỗi nặng không thể sửa chữa Hoàng Kiên
            trợ giá 50% cho khách hàng mua máy mới NGANG DÒNG ( khi số tiền bán
            hộ thấp hơn 50% giá Web ) và Hoàng Kiên sẽ thu hồi lại máy hỏng.
          </span>
        </p>
      </div>
    </StaticTemplate>
  );
};

export default WarrantyPolicy;
