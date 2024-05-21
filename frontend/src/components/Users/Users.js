import { React, Component } from "react";
import { request } from "../../api/api-client";
import "./Users.css";
import UserInfo from "../UserInfo/UserInfo";

class Users extends Component {
  state = {
    users: null,
    isLoading: true,
  };

  async componentDidMount() {
    await request("GET", "/users")
      .then((response) => {
        this.setState({ users: response.data, isLoading: false });
      })
      .catch((error) => {
        this.setState({ users: "error" });
      });
  }

  render() {
    const { users, isLoading } = this.state;
    let userData = null;

    if (!isLoading) {
      userData = users.map((user) => (
        <UserInfo username={user.username} lastLogin={user.lastLogin} />
      ));
    }

    return (
      <div className="content">
        <div className="users tile">
          <h1 className="users__title">Users</h1>
          <table className="users__table">
            <tr>
              <th className="users__heading">USERNAME</th>
              <th className="users__heading">LAST LOGIN</th>
            </tr>
            {userData}
          </table>
        </div>
      </div>
    );
  }
}

export default Users;
