import React from "react";
import { Link } from "react-router-dom";
import "./Dashboard.css";

const Dashboard = () => {
  return (
    <>
      <div className="dashboard">
        <div className="dashboard__up">
          <div className="dashboard__threats">
            <h1 className="dashboard__title">Threats</h1>
            <span className="dashboard__value">43</span>
            <Link to="/home/monitoring">
              <button className="dashboard__btn">View more {">>"}</button>
            </Link>
          </div>
          <div className="dashboard__traffic">
            <h1 className="dashboard__title left__title">Traffic</h1>
            <span className="dashboard__chart">chart</span>
          </div>
        </div>
        <div className="dashboard__bottom">
          <div className="dashboard__ips">
            <h1 className="dashboard__title left__title">Common Ip's</h1>
            <div className="dashboard__chart">chart</div>
          </div>
          <div className="dashboard__hosts">
            <h1 className="dashboard__title">Hosts</h1>
            <span className="dashboard__value">8</span>
            <Link to="/home/monitoring">
              <button className="dashboard__btn">View more {">>"}</button>
            </Link>
          </div>
        </div>
      </div>
    </>
  );
};

export default Dashboard;
