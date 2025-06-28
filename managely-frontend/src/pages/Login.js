import React, { useState } from "react";
import axios from "axios";
import "../Login.css"; // 💡 Rename Style.css to Login.css and place in src/

function Login({ onLogin }) {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    const credentials = btoa(`${username}:${password}`);

    try {
      const response = await axios.get("http://localhost:8083/api/employees", {
        headers: {
          Authorization: `Basic ${credentials}`,
        },
      });
      alert("Login successful!");
      onLogin(credentials); // Save the login session
    } catch (error) {
      alert("Invalid credentials");
    }
  };

  return (
    <div>
      <h1>Managely: Smart Employee</h1>
      <div className="main">
        <h3>Login For Manager</h3>
        <form onSubmit={handleSubmit}>
          <label htmlFor="username">Username:</label>
          <input
            type="text"
            id="username"
            placeholder="Enter Username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
          />

          <label htmlFor="password">Password:</label>
          <input
            type="password"
            id="password"
            placeholder="Enter Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />

          <div className="wrap">
            <button type="submit">Submit</button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Login;
