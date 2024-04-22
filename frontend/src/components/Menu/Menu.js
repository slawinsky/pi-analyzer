import React, { useState } from "react";
import "./Menu.css";
import { Link, NavLink } from "react-router-dom";
import UserIcon from "../../icons/user.svg";
import Hamburger from "../Hamburger/Hamburger";

const Menu = () => {
  const [isOpen, setOpen] = useState(false);

  return (
    <div className="menu">
      <h1 className="menu__title">Pi Analyzer</h1>
      <Hamburger
        isOpen={isOpen}
        onOpen={() => {
          setOpen(!isOpen);
        }}
      />
      <nav className={`menu__nav ${isOpen ? "open" : ""}`}>
        <ul className="menu__list">
          <NavLink
            to="/home/dashboard"
            onClick={() => {
              setOpen(!isOpen);
            }}
          >
            <li className="menu__element">Home</li>
          </NavLink>

          <Link
            className="menu__element"
            to="/home/hosts"
            onClick={() => {
              setOpen(!isOpen);
            }}
          >
            <li>Hosts</li>
          </Link>

          <Link
            to="/home/monitoring"
            onClick={() => {
              setOpen(!isOpen);
            }}
          >
            <li className="menu__element">Monitoring</li>
          </Link>

          <Link
            to="/home/firewall"
            onClick={() => {
              setOpen(!isOpen);
            }}
          >
            <li className="menu__element">Firewall</li>
          </Link>

          <Link
            to="/home/users"
            onClick={() => {
              setOpen(!isOpen);
            }}
          >
            <li className="menu__element">Users</li>
          </Link>
        </ul>

        <div className="menu__user">
          <img src={UserIcon} alt="user-icon" />
          <h3 className="menu__username">
            <Link
              to="/home/profile"
              onClick={() => {
                setOpen(!isOpen);
              }}
            >
              Admin
            </Link>
          </h3>
        </div>
      </nav>
    </div>
  );
};

export default Menu;
