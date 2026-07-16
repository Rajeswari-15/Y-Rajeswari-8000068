import React from "react";
import CalculateScore from "./Components/CalculateScore";

function App() {
    return (
        <div>
            <CalculateScore
                Name="Nandini"
                School="MRECW"
                Total={450}
                Goal={5}
            />
        </div>
    );
}

export default App;