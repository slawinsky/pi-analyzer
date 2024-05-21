import { React, Component } from "react";
import { Link } from "react-router-dom";
import { request } from "../../api/api-client";
import { Bar } from "react-chartjs-2";
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
} from "chart.js";
import "./Dashboard.css";

ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
);

class Dashboard extends Component {
  state = {
    threats: 0,
    hosts: 0,
    ips: null,
    protocols: null,
    isIpsLoading: true,
    isProtocolsLoading: true,
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

    await request("GET", "/ip/hits")
      .then((response) => {
        this.setState({ ips: response.data, isIpsLoading: false });
      })
      .catch((error) => {
        this.setState({ ips: "error" });
      });

    await request("GET", "/protocol")
      .then((response) => {
        this.setState({ protocols: response.data, isProtocolsLoading: false });
      })
      .catch((error) => {
        this.setState({ protocols: "error" });
      });
  }

  render() {
    const { hosts, threats, ips, protocols, isIpsLoading, isProtocolsLoading } =
      this.state;
    let ipsChartData,
      protocolsChartData = null;
    let protocolsChart,
      ipsChart = "loading...";
    const chartOptions = {
      maintainAspectRatio: false,
    };

    if (!isIpsLoading) {
      ipsChartData = {
        labels: [ips[0].ip, ips[1].ip, ips[2].ip, ips[3].ip, ips[4].ip],
        datasets: [
          {
            label: "Hits",
            data: [
              ips[0].hits,
              ips[1].hits,
              ips[2].hits,
              ips[3].hits,
              ips[4].hits,
            ],
            backgroundColor: "rgba(75, 192, 192, 0.7)",
          },
        ],
      };

      ipsChart = (
        <div className="chart__wrapper">
          <Bar data={ipsChartData} options={chartOptions} />
        </div>
      );
    }

    if (!isProtocolsLoading) {
      protocolsChartData = {
        labels: [
          protocols[0].protocol,
          protocols[1].protocol,
          protocols[2].protocol,
          protocols[3].protocol,
        ],
        datasets: [
          {
            label: "Hits",
            data: [
              protocols[0].hits,
              protocols[1].hits,
              protocols[2].hits,
              protocols[3].hits,
            ],
            backgroundColor: "rgba(75, 192, 192, 0.7)",
          },
        ],
      };

      protocolsChart = (
        <div className="chart__wrapper">
          <Bar data={protocolsChartData} options={chartOptions} />
        </div>
      );
    }

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
            <div className="dashboard__chart">{protocolsChart}</div>
          </div>
        </div>
        <div className="dashboard__bottom">
          <div className="dashboard__ips tile tile-wide">
            <h1 className="dashboard__title left__title">Common Ip's</h1>
            <div className="dashboard__chart">{ipsChart}</div>
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
