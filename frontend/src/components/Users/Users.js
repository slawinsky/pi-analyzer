import React from "react";
import "./Users.css";

const Users = () => {
  return (
    <div className="content">
      <div className="users">
        <h1 className="users__title">Users</h1>
        <table className="users__table">
          <tr>
            <th className="users__heading">USERNAME</th>
            <th className="users__heading">LAST LOGIN</th>
          </tr>
          <tr>
            <td>Jakub</td>
            <td>19-03-24 18:00:00</td>
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
        </table>
      </div>
    </div>
  );
};

export default Users;
