import React from "react";
import "./Menu.css";
import { Link, NavLink } from "react-router-dom";
import UserIcon from "../../icons/user.svg";

const Menu = () => {
  return (
    <div className="menu">
      <h1 className="menu__title">Pi Analyzer</h1>
      <nav className="menu__nav">
        <ul className="menu__list">
          <NavLink to="/home/dashboard">
            <li className="menu__element">Home</li>
          </NavLink>

          <Link className="menu__element" to="/home/hosts">
            <li>Hosts</li>
          </Link>

          <Link to="/home/monitoring">
            <li className="menu__element">Monitoring</li>
          </Link>

          <Link to="/home/firewall">
            <li className="menu__element">Firewall</li>
          </Link>

          <Link to="/home/users">
            <li className="menu__element">Users</li>
          </Link>
        </ul>
      </nav>
      <div className="menu__user">
        <img src={UserIcon} alt="user-icon" />
        <h3 className="menu__username">
          <Link to="/home/profile">Admin</Link>
        </h3>
      </div>
    </div>
  );
};

export default Menu;
