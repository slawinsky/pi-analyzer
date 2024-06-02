import React from "react";
import { request, getUsername, removeToken } from "../../api/api-client";

const UserInfo = ({ username, lastLogin }) => {
  const handleUsernameChange = async (e) => {
    const currentUsername = getUsername();
    const changedUsername = window.prompt("New username:");

    if (changedUsername === null || changedUsername === "") {
      alert("Wrong username!");
      return;
    }

    const usernameChangeData = JSON.stringify({
      username: username,
      changedUsername: changedUsername,
    });

    await request("PUT", "/user/name", usernameChangeData)
      .then(() => {
        alert("Username changed!");
        if (currentUsername === username) {
          removeToken();
          window.location = "/login";
        } else {
          window.location = "/home/users";
        }
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
      username: username,
      changedPassword: changedPassword,
    });

    await request("PUT", "/user/password", passwordChangeData)
      .then(() => {
        alert("Password changed!");
        if (currentUsername === username) {
          removeToken();
          window.location = "/login";
        }
      })
      .catch(() => {
        alert("Error");
      });
  };

  const handleUserDelete = async (e) => {
    const currentUsername = getUsername();

    if (currentUsername === username) {
      alert("You cannot delete your own account!");
    }

    await request("DELETE", `/user/${username}`)
      .then(() => {
        alert("User deleted!");
        window.location = "/home/users";
      })
      .catch(() => {
        alert("Error");
      });
  };

  return (
    <tr>
      <td>{username}</td>
      <td>{lastLogin}</td>
      <td>
        <button className="users__btn change" onClick={handleUsernameChange}>
          change name
        </button>
      </td>
      <td>
        <button className="users__btn reset" onClick={handlePasswordChange}>
          reset password
        </button>
      </td>
      <td>
        <button className="users__btn delete" onClick={handleUserDelete}>
          delete
        </button>
      </td>
    </tr>
  );
};

export default UserInfo;
