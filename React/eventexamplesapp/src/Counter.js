import React, { Component } from "react";

class Counter extends Component {

    constructor(props) {
        super(props);

        this.state = {
            count: 0
        };
    }

    increment = () => {
        this.setState({
            count: this.state.count + 1
        });
    };

    decrement = () => {
        this.setState({
            count: this.state.count - 1
        });
    };

    sayHello = () => {
        alert("Hello! Counter has been increased.");
    };

    handleIncrement = () => {
        this.increment();   // Method 1
        this.sayHello();    // Method 2
    };

    sayWelcome = (message) => {
        alert(message);
    };

    onPress = () => {
        alert("I was clicked");
    };

    render() {

        return (
            <div>

                <h2>Counter Example</h2>

                <h3>Counter Value : {this.state.count}</h3>

                <button onClick={this.handleIncrement}>
                    Increment
                </button>

                <button onClick={this.decrement}>
                    Decrement
                </button>

                <br /><br />

                <button
                    onClick={() => this.sayWelcome("Welcome")}
                >
                    Say Welcome
                </button>

                <br /><br />

                <button onClick={this.onPress}>
                    OnPress
                </button>

            </div>
        );
    }
}

export default Counter;