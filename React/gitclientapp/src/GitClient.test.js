import axios from "axios";
import GitClient from "./GitClient";

// Mock axios
jest.mock("axios");

describe("Git Client Tests", () => {

    test("should return repository names for techiesyed", async () => {

        // Dummy Data
        const mockedResponse = {
            data: [
                { name: "ReactProject" },
                { name: "WeatherApp" },
                { name: "Portfolio" }
            ]
        };

        // Mock axios.get()
        axios.get.mockResolvedValue(mockedResponse);

        // Call Method
        const repos = await GitClient.getRepositories("techiesyed");

        // Verify Result
        expect(repos).toEqual([
            "ReactProject",
            "WeatherApp",
            "Portfolio"
        ]);

        // Verify axios was called correctly
        expect(axios.get).toHaveBeenCalledWith(
            "https://api.github.com/users/techiesyed/repos"
        );

    });

});