import React, { Component } from "react";
import GitClient from "./GitClient";

class App extends Component {

    constructor(props) {
        super(props);

        this.state = {
            repositories: []
        };
    }

    async componentDidMount() {

        const repos = await GitClient.getRepositories("techiesyed");

        this.setState({
            repositories: repos
        });

    }

    render() {

        return (

            <div style={{ margin: "20px" }}>

                <h2>GitHub Repository List</h2>

                <ul>

                    {this.state.repositories.map((repo, index) => (

                        <li key={index}>
                            {repo}
                        </li>

                    ))}

                </ul>

            </div>

        );
    }
}

export default App;