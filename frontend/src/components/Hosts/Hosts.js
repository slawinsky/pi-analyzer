import { React, Component } from "react";
import { request } from "../../api/api-client";
import "./Hosts.css";
import Host from "../Host/Host";

class Hosts extends Component {
  state = {
    data: null,
    isLoading: true,
  };

  async componentDidMount() {
    await request("GET", "/hosts/list")
      .then((response) => {
        return response.data.map((data) => JSON.parse(data));
      })
      .then((data) => {
        this.setState({ data, isLoading: false });
      })
      .catch((error) => {
        this.setState({ data: "error" });
      });
  }

  render() {
    const { data, isLoading } = this.state;

    let HostList = "";

    if (!isLoading) {
      HostList = data.map((host) => (
        <Host
          ip={host.ip}
          mac={host.mac}
          name={host.name}
          time={host.lastConnected.$date}
        />
      ));
    }

    return (
      <div className="content">
        <div className="hosts tile">
          <h1 className="hosts__title left__title">Hosts</h1>
          <table className="hosts__table">
            <tbody>
              <tr>
                <th className="hosts__heading ip">IP ADDRESS</th>
                <th className="hosts__heading mac">MAC ADDRESS</th>
                <th className="hosts__heading name">NAME</th>
                <th className="hosts__heading time">CONNECTION TIME</th>
              </tr>
              {HostList}
            </tbody>
          </table>
          <button className="hosts__btn btn-green view">
            View blocked hosts {">>"}
          </button>
        </div>
      </div>
    );
  }
}

export default Hosts;
