import { React, Component } from "react";
import { request } from "../../api/api-client";
import "./Monitoring.css";

class Monitoring extends Component {
  state = {
    threats: null,
    isLoading: true,
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
  }

  render() {
    const { threats, isLoading } = this.state;

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
            <span className="monitoring__chart">chart</span>
          </div>
        </div>
        <div className="monitoring__bottom">
          <div className="monitoring__ips tile tile-wide">
            <h1 className="monitoring__title left__title">Common Ip's</h1>
            <div className="monitoring__chart">chart</div>
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
