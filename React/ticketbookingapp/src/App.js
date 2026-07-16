import React, { Component } from "react";
import GuestPage from "./GuestPage";
import UserPage from "./UserPage";
import Login from "./Login";
import Logout from "./Logout";

class App extends Component {

    constructor(props) {
        super(props);

        this.state = {
            isLoggedIn: false
        };
    }

    login = () => {
        this.setState({
            isLoggedIn: true
        });
    };

    logout = () => {
        this.setState({
            isLoggedIn: false
        });
    };

    render() {

        let page;
        let button;

        if (this.state.isLoggedIn) {
            page = <UserPage />;
            button = <Logout onLogout={this.logout} />;
        } else {
            page = <GuestPage />;
            button = <Login onLogin={this.login} />;
        }

        return (

            <div style={{ textAlign: "center" }}>

                <h1>Ticket Booking App</h1>

                {button}

                <hr />

                {page}

            </div>

        );
    }
}

export default App;