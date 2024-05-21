import React from "react";

const UserInfo = ({ username, lastLogin }) => {
  return (
    <tr>
      <td>{username}</td>
      <td>{lastLogin}</td>
      <td>
        <button className="users__btn change">change name</button>
      </td>
      <td>
        <button className="users__btn reset">reset password</button>
      </td>
      <td>
        <button className="users__btn delete">delete</button>
      </td>
    </tr>
  );
};

export default UserInfo;
