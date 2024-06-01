import React from "react";
import UserIcon from "../../icons/user.svg";
import { request, getUsername, removeToken } from "../../api/api-client";
import "./User.css";

const User = () => {
  const handleUsernameChange = async (e) => {
    const currentUsername = getUsername();
    const changedUsername = window.prompt("New username:");

    if (changedUsername === null || changedUsername === "") {
      alert("Wrong username!");
      return;
    }

    const usernameChangeData = JSON.stringify({
      username: currentUsername,
      changedUsername: changedUsername,
    });

    await request("PUT", "/user/name", usernameChangeData)
      .then(() => {
        alert("Username changed!");
        removeToken();
        window.location = "/login";
      })
      .catch(() => {
        alert("Error");
      });
  };

  const handlePasswordChange = async (e) => {
    const currentUsername = getUsername();
    const changedPassword = window.prompt("New password:");

    if (changedPassword === null || changedPassword === "") {
      alert("Wrong password!");
      return;
    }

    const passwordChangeData = JSON.stringify({
      username: currentUsername,
      changedPassword: changedPassword,
    });

    await request("PUT", "/user/password", passwordChangeData)
      .then(() => {
        alert("Password changed!");
        removeToken();
        window.location = "/login";
      })
      .catch(() => {
        alert("Error");
      });
  };

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
        <button className="users__btn change" onClick={handleUsernameChange}>
          change name
        </button>
        <button className="users__btn change" onClick={handlePasswordChange}>
          change password
        </button>
        <button className="users__btn btn-red" onClick={handleLogout}>
          logout
        </button>
      </div>
    </div>
  );
};

export default User;
