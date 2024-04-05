import React from "react";
import { useState } from "react";
import "./Login.css";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
  };

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
          onClick={handleSubmit}
        />
      </form>
    </div>
  );
};

export default Login;
