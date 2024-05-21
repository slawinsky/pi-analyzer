import { React, Component } from "react";
import { request } from "../../api/api-client";
import { Bar } from "react-chartjs-2";
import "./Monitoring.css";

class Monitoring extends Component {
  state = {
    threats: null,
    isLoading: true,
    ips: null,
    protocols: null,
    isIpsLoading: true,
    isProtocolsLoading: true,
  };

  async componentDidMount() {
    await request("GET", "/threats/ip")
      .then((response) => {
        return response.data.map((data) => JSON.parse(data));
      })
      .then((threats) => {
        this.setState({ threats, isLoading: false });
      })
      .catch((error) => {
        this.setState({ threats: "error" });
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
    const {
      threats,
      isLoading,
      ips,
      protocols,
      isIpsLoading,
      isProtocolsLoading,
    } = this.state;
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
      <div className="monitoring content">
        <div className="monitoring__up">
          <div className="monitoring__notifications tile tile-thin">
            <h1 className="monitoring__title">Mail notification</h1>
            <form className="monitoring__form">
              <input
                type="text"
                placeholder="Mail address"
                className="monitoring__input"
              />
              <input
                type="password"
                placeholder="Password"
                className="monitoring__input"
              />
              <input
                type="text"
                placeholder="Server address"
                className="monitoring__input"
              />
              <input
                type="number"
                placeholder="Port"
                className="monitoring__input"
              />
              <input
                type="submit"
                className="monitoring__submit"
                value="CONFIGURE"
              />
            </form>
          </div>
          <div className="monitoring__traffic tile tile-wide">
            <h1 className="monitoring__title left__title">Traffic</h1>
            <span className="monitoring__chart">{protocolsChart}</span>
          </div>
        </div>
        <div className="monitoring__bottom">
          <div className="monitoring__ips tile tile-wide">
            <h1 className="monitoring__title left__title">Common Ip's</h1>
            <div className="monitoring__chart">{ipsChart}</div>
          </div>
          <div className="monitoring__threats tile tile-thin">
            <h1 className="monitoring__title">Threats</h1>
            <ul className="monitoring__list">
              <li className="monitoring__threat">
                {isLoading ? "" : threats[0].ip}
              </li>
              <li className="monitoring__threat">
                {isLoading ? "" : threats[1].ip}
              </li>
              <li className="monitoring__threat">
                {isLoading ? "" : threats[2].ip}
              </li>
            </ul>
          </div>
        </div>
      </div>
    );
  }
}

export default Monitoring;
