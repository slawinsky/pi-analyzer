import React from "react";
import { useState } from "react";
import { request, setAuthToken } from "../../api/api-client";
import { Navigate } from "react-router-dom";

import "./Login.css";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [loggedIn, setLoggedIn] = useState(false);

  const handleSignIn = async (e) => {
    e.preventDefault();

    const loginData = JSON.stringify({
      username: username,
      password: password,
    });

    await request("POST", "/authenticate", loginData)
      .then((response) => {
        setAuthToken(response.data.token);
        setLoggedIn(true);
      })
      .catch((error) => {
        return <Navigate to="/login" />;
      });
  };

  if (loggedIn) {
    return <Navigate to="/home" />;
  }

  return (
    <div className="login">
      <h1 className="login__title">Pi Analyzer</h1>
      <form className="login__form">
        <input
          className="login__input"
          type="text"
          name="username"
          placeholder="Username"
          required
          value={username}
          onChange={(e) => {
            setUsername(e.target.value);
          }}
        />
        <input
          className="login__input"
          type="password"
          name="password"
          placeholder="Password"
          required
          value={password}
          onChange={(e) => {
            setPassword(e.target.value);
          }}
        />
        <input
          className="login__submit"
          type="submit"
          value="LOGIN"
          onClick={handleSignIn}
        />
      </form>
    </div>
  );
};

export default Login;
