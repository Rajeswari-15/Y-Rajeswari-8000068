import React from "react";
import "./App.css";

function App() {

  // List of Office Spaces
  const offices = [
    {
      name: "Tech Park Office",
      rent: 55000,
      address: "Hitech City, Hyderabad",
      image:
        "https://images.unsplash.com/photo-1497366754035-f200968a6e72?w=600"
    },
    {
      name: "Business Hub",
      rent: 75000,
      address: "Gachibowli, Hyderabad",
      image:
        "https://images.unsplash.com/photo-1497366412874-3415097a27e7?w=600"
    },
    {
      name: "Corporate Tower",
      rent: 65000,
      address: "Madhapur, Hyderabad",
      image:
        "https://images.unsplash.com/photo-1497366811353-6870744d04b2?w=600"
    }
  ];

  return (
    <div className="container">

      {/* Heading */}
      <h1>Office Space Rental App</h1>

      {/* Display Office Details */}
      {offices.map((office, index) => (
        <div key={index} className="card">

          <img
            src={office.image}
            alt={office.name}
            width="350"
            height="220"
          />

          <h2>{office.name}</h2>

          <p
            style={{
              color: office.rent < 60000 ? "red" : "green",
              fontWeight: "bold"
            }}
          >
            Rent: ₹{office.rent}
          </p>

          <p>Address: {office.address}</p>

        </div>
      ))}

    </div>
  );
}

export default App;