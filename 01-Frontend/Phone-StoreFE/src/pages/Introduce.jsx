import React from "react";
import StaticTemplate from "./StaticTemplate";

const Introduce = () => {
  return (
    <StaticTemplate>
      <div>
        <div className="page-title">
          <h1>Giới thiệu</h1>
        </div>
        <div className="page-content">
          <p>
            <strong>MT-Store: &adr;</strong>
            được thành lập từ năm 2008, hoạt động chủ yếu trong lĩnh vực nhập
            khẩu và phân phối các dòng sản phẩm iPhone chính hãng. Trong suốt
            những năm hoạt động với mong muốn đem đến những trải nghiệm và giá
            trị đích thực của công nghệ tới những người yêu công nghệ trên khắp
            mọi miền, Hoàng Kiên luôn cố gắng đem đến những sản phẩm chất lượng
            nhất đi kèm với chế độ sau bán hàng chuyên nghiệp nhất đến với khách
            hàng.
          </p>
          <p>
            Các dòng sản phẩm được Hoàng Kiên phân phối chủ yếu bao gồm các dòng
            iPhone của hãng Apple... với chất lượng hàng đầu và giá cả phù hợp
            với mọi đối tượng khách hàng.
          </p>
          <p>
            <span>
              Với mong muốn và tham vọng trở thành nhà phân phối hàng đầu các
              dòng iPhone tại thị trường Việt Nam, Hoàng Kiên luôn cố gắng khẳng
              định mình là một nhà phân phối uy tín, chất lượng với dịch vụ bán
              hàng và sau bán hàng đi đầu, luôn đáp ứng được các yêu cầu của
              khách hàng. Hoàng Kiên luôn cam kết với khách hàng về chất lượng
              sản phẩm, giá cả, chất lượng khuyến mãi và hậu mãi tốt nhất.
            </span>
          </p>
          <p>
            <span>
              Cuối cùng Xin cảm ơn quý khách đã quan tâm đến dịch vụ của chúng
              tôi. Sự hài lòng của quý khách là sự thành công của chúng tôi.
            </span>
          </p>
        </div>
      </div>
    </StaticTemplate>
  );
};

export default Introduce;
