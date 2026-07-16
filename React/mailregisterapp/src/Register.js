import React, { Component } from "react";

class Register extends Component {

    constructor(props) {
        super(props);

        this.state = {
            name: "",
            email: "",
            password: "",
            errors: {}
        };
    }

    // Handle Input Change
    handleChange = (event) => {
        this.setState({
            [event.target.name]: event.target.value
        });
    };

    // Form Validation
    validateForm = () => {

        let errors = {};
        let isValid = true;

        // Name Validation
        if (this.state.name.length < 5) {
            errors.name = "Name must contain at least 5 characters";
            isValid = false;
        }

        // Email Validation
        if (
            !this.state.email.includes("@") ||
            !this.state.email.includes(".")
        ) {
            errors.email = "Email must contain @ and .";
            isValid = false;
        }

        // Password Validation
        if (this.state.password.length < 8) {
            errors.password = "Password must contain at least 8 characters";
            isValid = false;
        }

        this.setState({
            errors: errors
        });

        return isValid;
    };

    // Handle Submit
    handleSubmit = (event) => {

        event.preventDefault();

        if (this.validateForm()) {

            alert("Registration Successful!");

            this.setState({
                name: "",
                email: "",
                password: "",
                errors: {}
            });

        }

    };

    render() {

        return (

            <div className="container">

                <h2>Mail Registration Form</h2>

                <form onSubmit={this.handleSubmit}>

                    <label>Name</label>

                    <br />

                    <input
                        type="text"
                        name="name"
                        value={this.state.name}
                        onChange={this.handleChange}
                    />

                    <br />

                    <span className="error">
                        {this.state.errors.name}
                    </span>

                    <br /><br />

                    <label>Email</label>

                    <br />

                    <input
                        type="text"
                        name="email"
                        value={this.state.email}
                        onChange={this.handleChange}
                    />

                    <br />

                    <span className="error">
                        {this.state.errors.email}
                    </span>

                    <br /><br />

                    <label>Password</label>

                    <br />

                    <input
                        type="password"
                        name="password"
                        value={this.state.password}
                        onChange={this.handleChange}
                    />

                    <br />

                    <span className="error">
                        {this.state.errors.password}
                    </span>

                    <br /><br />

                    <button type="submit">
                        Register
                    </button>

                </form>

            </div>

        );
    }
}

export default Register;