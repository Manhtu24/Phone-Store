import React from "react";
import { assets } from "../../assets/images/images";

const Home = () => {
  return (
    <div className="bg-gray-100 ">
      <div className="relative ">
        <div className="">
          <img src={assets.home1} loading="lazy" alt="Introduction 1" />
          <img src="" alt="" />
          <img src="" alt="" />
        </div>
        <div className=" flex gap-3 mx-4 md:mx-16 lg:mx-28 static xl:absolute xl:top-[75%] xl:z-4">
          <div className="w-[50%] h-[270px] overflow-hidden ">
            <img
              src={assets.smallHome1}
              alt="SmallHome"
              className="transition-transform duration-700 ease-in-out hover:scale-110"
            />
          </div>
          <div className="w-[50%] h-[270px] overflow-hidden">
            <img
              src={assets.smallHome2}
              alt="SmallHome"
              className="transition-transform duration-700 ease-in-out hover:scale-110 "
            />
          </div>
        </div>
      </div>
      <div className="pt-[140px]">
        <h2>This is a new website</h2>
        <h3>Hơ to fix</h3>
      </div>
    </div>
  );
};

export default Home;
