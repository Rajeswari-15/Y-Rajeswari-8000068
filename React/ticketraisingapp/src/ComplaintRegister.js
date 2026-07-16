import React, { Component } from "react";

class ComplaintRegister extends Component {

    constructor(props) {
        super(props);

        this.state = {
            employeeName: "",
            complaint: ""
        };
    }

    // Handle Employee Name
    handleNameChange = (event) => {
        this.setState({
            employeeName: event.target.value
        });
    };

    // Handle Complaint
    handleComplaintChange = (event) => {
        this.setState({
            complaint: event.target.value
        });
    };

    // Handle Form Submit
    handleSubmit = (event) => {

        event.preventDefault();

        // Generate Random Reference Number
        const referenceNo = Math.floor(Math.random() * 1000000);

        alert(
            `Complaint Registered Successfully!\n\nEmployee Name: ${this.state.employeeName}\nReference Number: ${referenceNo}`
        );

        // Clear Form
        this.setState({
            employeeName: "",
            complaint: ""
        });
    };

    render() {

        return (

            <div className="container">

                <h2>Ticket Raising App</h2>

                <form onSubmit={this.handleSubmit}>

                    <label>
                        Employee Name
                    </label>

                    <br />

                    <input
                        type="text"
                        placeholder="Enter Employee Name"
                        value={this.state.employeeName}
                        onChange={this.handleNameChange}
                        required
                    />

                    <br /><br />

                    <label>
                        Complaint
                    </label>

                    <br />

                    <textarea
                        rows="5"
                        cols="40"
                        placeholder="Enter your complaint"
                        value={this.state.complaint}
                        onChange={this.handleComplaintChange}
                        required
                    />

                    <br /><br />

                    <button type="submit">
                        Submit Complaint
                    </button>

                </form>

            </div>

        );
    }
}

export default ComplaintRegister;