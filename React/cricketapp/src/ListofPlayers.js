import React from "react";

function ListofPlayers() {

    const players = [
        { name: "Virat Kohli", score: 95 },
        { name: "Rohit Sharma", score: 82 },
        { name: "Shubman Gill", score: 67 },
        { name: "KL Rahul", score: 45 },
        { name: "Hardik Pandya", score: 75 },
        { name: "Ravindra Jadeja", score: 69 },
        { name: "Rishabh Pant", score: 88 },
        { name: "Surya Kumar", score: 61 },
        { name: "Ashwin", score: 73 },
        { name: "Bumrah", score: 58 },
        { name: "Mohammed Siraj", score: 77 }
    ];

    // Filter players with score below 70
    const lowScorePlayers = players.filter(player => player.score < 70);

    return (
        <div>
            <h2>List of Players</h2>

            <h3>All Players</h3>

            <ul>
                {players.map((player, index) => (
                    <li key={index}>
                        {player.name} - {player.score}
                    </li>
                ))}
            </ul>

            <h3>Players with Score Below 70</h3>

            <ul>
                {lowScorePlayers.map((player, index) => (
                    <li key={index}>
                        {player.name} - {player.score}
                    </li>
                ))}
            </ul>

        </div>
    );
}

export default ListofPlayers;