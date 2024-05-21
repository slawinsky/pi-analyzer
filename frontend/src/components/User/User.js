import React from "react";
import UserIcon from "../../icons/user.svg";
import { getUsername, removeToken } from "../../api/api-client";
import { Navigate } from "react-router-dom";
import "./User.css";

const User = () => {
  const handleLogout = (e) => {
    e.preventDefault();
    removeToken();
    window.location = "/login";
  };

  return (
    <div className="content">
      <div className="user tile">
        <img className="user__image" src={UserIcon} alt="user-icon" />
        <h1 className="user__title">{getUsername()}</h1>
        <button className="users__btn change">change name</button>
        <button className="users__btn change">change password</button>
        <button className="users__btn btn-red" onClick={handleLogout}>
          logout
        </button>
      </div>
    </div>
  );
};

export default User;
