import React, { useState } from "react";
import Login from "./pages/Login";
import Dashboard from "./pages/Dashboard";

function App() {
  const [authToken, setAuthToken] = useState(null);

  return (
    <div>
      {!authToken ? (
        <Login onLogin={(token) => setAuthToken(token)} />
      ) : (
        <Dashboard token={authToken} />
      )}
    </div>
  );
}

export default App;
