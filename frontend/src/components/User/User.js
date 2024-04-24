import React from "react";
import UserIcon from "../../icons/user.svg";
import "./User.css";

const User = () => {
  return (
    <div className="content">
      <div className="user tile">
        <img className="user__image" src={UserIcon} alt="user-icon" />
        <h1 className="user__title">Jakub</h1>
        <button className="users__btn change">change name</button>
        <button className="users__btn change">change password</button>
        <button className="users__btn btn-red">logout</button>
      </div>
    </div>
  );
};

export default User;
