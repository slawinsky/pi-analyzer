import React, { Component } from "react";
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import Login from "./components/Login/Login";
import Home from "./components/Home/Home";
import NotFound from "./components/NotFound/NotFound";

class App extends Component {
  render() {
    return (
      <BrowserRouter>
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/home/*" element={<Home />} />
          <Route path="*" element={<Navigate to="/not-found" replace />} />
          <Route path="/not-found" element={<NotFound />} />
        </Routes>
      </BrowserRouter>
    );
  }
}

export default App;
