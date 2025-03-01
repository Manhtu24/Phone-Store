import React from "react";
import SearchIcon from "@mui/icons-material/Search";

const SearchBar = () => {
  return (
    <div className="flex items-center rounded-lg border border-gray-300 p-2 bg-white w-70 ">
      <input
        type="text"
        placeholder="Bạn cần tìm gì..."
        className="flex-1 border-none focus:outline-none text-gray-500"
      />
      <button className="ml-2 hover:bg-red-500">
        <SearchIcon className="text-gray-500" />
      </button>
    </div>
  );
};

export default SearchBar;
