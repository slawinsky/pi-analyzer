import React from "react";
import { Route, Routes } from "react-router-dom";
import Dashboard from "../Dashoard/Dashboard";
import Menu from "../Menu/Menu";
import Hosts from "../Hosts/Hosts";
import Monitoring from "../Monitoring/Monitoring";
import Firewall from "../Firewall/Firewall";
import Users from "../Users/Users";
import User from "../User/User";
import "./Home.css";

const Home = () => {
  return (
    <div className="home">
      <Menu />
      <Routes>
        <Route path="dashboard" element={<Dashboard />} />
        <Route path="hosts" element={<Hosts />} />
        <Route path="monitoring" element={<Monitoring />} />
        <Route path="firewall" element={<Firewall />} />
        <Route path="users" element={<Users />} />
        <Route path="profile" element={<User />} />
      </Routes>
    </div>
  );
};

export default Home;
