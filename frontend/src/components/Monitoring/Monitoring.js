import React from "react";
import "./Monitoring.css";

const Monitoring = () => {
  return (
    <div className="monitoring content">
      <div className="monitoring__up">
        <div className="monitoring__notifications">
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
        <div className="monitoring__traffic">
          <h1 className="monitoring__title left__title">Traffic</h1>
          <span className="monitoring__chart">chart</span>
        </div>
      </div>
      <div className="monitoring__bottom">
        <div className="monitoring__ips">
          <h1 className="monitoring__title left__title">Common Ip's</h1>
          <div className="monitoring__chart">chart</div>
        </div>
        <div className="monitoring__threats">
          <h1 className="monitoring__title">Threats</h1>
          <ul className="monitoring__list">
            <li className="monitoring__threat">192.168.33.55</li>
            <li className="monitoring__threat">192.168.33.55</li>
            <li className="monitoring__threat">192.168.33.55</li>
          </ul>
        </div>
      </div>
    </div>
  );
};

export default Monitoring;
