import React from "react";

const StaticTemplate = ({ children }) => {
  return (
    <div className="bg-gray-300 py-3">
      <div className="mx-4 md:mx-16 lg:mx-28 bg-white">
        <div className="p-2">{children}</div>
      </div>
    </div>
  );
};
export default StaticTemplate;
