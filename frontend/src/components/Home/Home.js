import React from "react";
import { Route, Routes } from "react-router-dom";
import Dashboard from "../Dashoard/Dashboard";
import Menu from "../Menu/Menu";
import Hosts from "../Hosts/Hosts";
import "./Home.css";

const Home = () => {
  return (
    <div className="home">
      <Menu />
      <Routes>
        <Route path="dashboard" element={<Dashboard />} />
        <Route path="hosts" element={<Hosts />} />
      </Routes>
    </div>
  );
};

export default Home;
