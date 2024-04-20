import React from "react";
import { Link, Route, Routes } from "react-router-dom";
import Dashboard from "../Dashoard/Dashboard";

const Home = () => {
  return (
    <div className="home">
      <nav className="menu">
        <ul>
          <li>
            <Link to="/home/dashboard">Home</Link>
          </li>
          <li>
            <Link to="/home/hosts">Hosts</Link>
          </li>
          <li>
            <Link to="/home/monitoring">Monitoring</Link>
          </li>
          <li>
            <Link to="/home/firewall">Firewall</Link>
          </li>
          <li>
            <Link to="/home/users">Users</Link>
          </li>
        </ul>
      </nav>
      <Routes>
        <Route path="dashboard" element={<Dashboard />} />
      </Routes>
    </div>
  );
};

export default Home;
