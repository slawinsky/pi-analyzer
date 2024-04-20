import React from "react";
import { Route, Routes } from "react-router-dom";
import Dashboard from "../Dashoard/Dashboard";
import Menu from "../Menu/Menu";
import "./Home.css";

const Home = () => {
  return (
    <div className="home">
      <Menu />
      <Routes>
        <Route path="dashboard" element={<Dashboard />} />
      </Routes>
    </div>
  );
};

export default Home;
