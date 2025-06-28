import React, { useEffect, useState } from "react";
import axios from "axios";
import "../Dashboard.css"; // 👈 create this file using your CSS

function Dashboard({ token }) {
  const [employees, setEmployees] = useState([]);
  const [form, setForm] = useState({ id: "", name: "", age: "", salary: "" });

  const api = "http://localhost:8083/api/employees";

  useEffect(() => {
    loadEmployees();
  }, []);

  const loadEmployees = () => {
    axios
      .get(api, { headers: { Authorization: `Basic ${token}` } })
      .then((res) => setEmployees(res.data))
      .catch(() => alert("Failed to load employees"));
  };

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const emp = {
      name: form.name,
      age: parseInt(form.age),
      salary: parseFloat(form.salary),
    };
    const headers = { Authorization: `Basic ${token}` };

    if (form.id) {
      axios
        .put(`${api}/${form.id}`, emp, { headers })
        .then(() => {
          loadEmployees();
          resetForm();
        })
        .catch(() => alert("Failed to update employee"));
    } else {
      axios
        .post(api, emp, { headers })
        .then(() => {
          loadEmployees();
          resetForm();
        })
        .catch(() => alert("Failed to add employee"));
    }
  };

  const handleEdit = (emp) => {
    setForm(emp);
  };

  const handleDelete = (id) => {
    if (window.confirm("Delete this employee?")) {
      axios
        .delete(`${api}/${id}`, { headers: { Authorization: `Basic ${token}` } })
        .then(loadEmployees)
        .catch(() => alert("Failed to delete employee"));
    }
  };

  const resetForm = () => {
    setForm({ id: "", name: "", age: "", salary: "" });
  };

  return (
    <div className="container">
      <header>
        <h1>Employees</h1>
      </header>

      <form className="employee-form" onSubmit={handleSubmit}>
        <input
          type="text"
          name="name"
          placeholder="Employee Name"
          value={form.name}
          onChange={handleChange}
          required
        />
        <input
          type="number"
          name="age"
          placeholder="Age"
          value={form.age}
          onChange={handleChange}
          required
        />
        <input
          type="number"
          name="salary"
          placeholder="Salary"
          value={form.salary}
          onChange={handleChange}
          required
        />
        <button type="submit">{form.id ? "Update" : "Add Employee"}</button>
        {form.id && (
          <button type="button" onClick={resetForm} style={{ backgroundColor: "#6c757d", marginTop: "10px" }}>
            Cancel
          </button>
        )}
      </form>

      <div className="employee-list">
        <h2>Employee Records</h2>
        {employees.map((emp) => (
          <div className="card" key={emp.id}>
            <p><strong>Name:</strong> {emp.name}</p>
            <p><strong>Age:</strong> {emp.age}</p>
            <p><strong>Salary:</strong> ₹{emp.salary}</p>
            <div>
              <button onClick={() => handleEdit(emp)} style={{ marginRight: "10px" }}>Edit</button>
              <button onClick={() => handleDelete(emp.id)} style={{ backgroundColor: "#00040a" }}>Delete</button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Dashboard;
