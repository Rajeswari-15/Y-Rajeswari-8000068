import React from "react";
import "../Stylesheets/mystyle.css";

function CalculateScore(props) {

    const average = props.Total / props.Goal;

    return (
        <div className="container">
            <h2>Student Score Calculator</h2>

            <p><b>Name:</b> {props.Name}</p>

            <p><b>School:</b> {props.School}</p>

            <p><b>Total Marks:</b> {props.Total}</p>

            <p><b>Number of Subjects:</b> {props.Goal}</p>

            <p><b>Average Score:</b> {average}</p>
        </div>
    );
}

export default CalculateScore;