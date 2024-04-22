import React from "react";
import "./Hamburger.css";

const Hamburger = ({ isOpen, onOpen }) => {
  return (
    <div onClick={onOpen} className={`hamburger ${isOpen ? "open" : ""}`}>
      <span className="hamburger__bar bar-1" />
      <span className="hamburger__bar bar-2" />
      <span className="hamburger__bar bar-3" />
    </div>
  );
};

export default Hamburger;
