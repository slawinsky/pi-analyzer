import { React, Component } from "react";
import { Link } from "react-router-dom";
import { request } from "../../api/api-client";
import "./Dashboard.css";

class Dashboard extends Component {
  state = {
    threats: 0,
    hosts: 0,
  };

  async componentDidMount() {
    await request("GET", "/threats")
      .then((response) => {
        this.setState({ threats: response.data });
      })
      .catch((error) => {
        this.setState({ threats: "error" });
      });

    await request("GET", "/hosts/count")
      .then((response) => {
        this.setState({ hosts: response.data });
      })
      .catch((error) => {
        this.setState({ hosts: "error" });
      });
  }

  render() {
    const { hosts, threats } = this.state;

    return (
      <div className="dashboard content">
        <div className="dashboard__up">
          <div className="dashboard__threats tile tile-thin">
            <h1 className="dashboard__title">Threats</h1>
            <span className="dashboard__value">{threats}</span>
            <Link to="/home/monitoring">
              <button className="dashboard__btn btn-green">
                View more {">>"}
              </button>
            </Link>
          </div>
          <div className="dashboard__traffic tile tile-wide">
            <h1 className="dashboard__title left__title">Traffic</h1>
            <span className="dashboard__chart">chart</span>
          </div>
        </div>
        <div className="dashboard__bottom">
          <div className="dashboard__ips tile tile-wide">
            <h1 className="dashboard__title left__title">Common Ip's</h1>
            <div className="dashboard__chart">chart</div>
          </div>
          <div className="dashboard__hosts tile tile-thin">
            <h1 className="dashboard__title">Hosts</h1>
            <span className="dashboard__value">{hosts}</span>
            <Link to="/home/monitoring">
              <button className="dashboard__btn btn-green">
                View more {">>"}
              </button>
            </Link>
          </div>
        </div>
      </div>
    );
  }
}

export default Dashboard;
