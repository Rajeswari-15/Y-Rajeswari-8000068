import React, { Component } from "react";

class Getuser extends Component {

    constructor(props) {
        super(props);

        this.state = {
            title: "",
            firstName: "",
            image: "",
            loading: true
        };
    }

    async componentDidMount() {

        try {

            const response = await fetch("https://api.randomuser.me/");

            const data = await response.json();

            const user = data.results[0];

            this.setState({
                title: user.name.title,
                firstName: user.name.first,
                image: user.picture.large,
                loading: false
            });

        } catch (error) {
            console.log(error);
        }
    }

    render() {

        if (this.state.loading) {
            return <h2>Loading User...</h2>;
        }

        return (

            <div className="container">

                <h2>User Details</h2>

                <img
                    src={this.state.image}
                    alt="User"
                    width="180"
                    height="180"
                />

                <h3>
                    {this.state.title} {this.state.firstName}
                </h3>

            </div>

        );
    }
}

export default Getuser;