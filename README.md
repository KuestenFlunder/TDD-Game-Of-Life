# Game of Life with Websockets

Welcome to the `GameOfLife` project by `com.KuestenFlunder`. This is a modern implementation of John Conway's classic cellular automaton, with a twist - it utilizes WebSockets for delivering real-time game state updates.

## Features

- **Real-time Updates**: Using WebSockets, you can experience the Game of Life in real-time, with instantaneous state updates without any need for manual refreshes.
- **Test-Driven Development (TDD)**: This project has been developed following the principles of TDD, ensuring robustness and reliability. Every piece of code has been thoroughly tested before implementation, ensuring that the game functions as expected under various conditions.

## Coming Soon

- **Dockerized Deployment**: Stay tuned for a Dockerized version of both frontend and backend components, making it easier than ever to deploy and run the Game of Life on any platform.

## Project Structure

- `Cell`: Represents a single cell in the game grid.
- `CellState`: Defines the possible states (alive or dead) of a cell.
- `GameOfLiveWebSocketHandler`: Manages the WebSocket connections and handles the game state broadcasts.
- `Playground`: The main game board or grid where the cells live.
- `SparkOfLife`: Contains the game's logic and rules for cell evolution.
- `UIOutput`: Interface for rendering the game state to the user.
- `UnitTestingApplication`: Contains unit tests for the various components of the project.
- `WebsocketConfig`: Configuration settings for the WebSocket connections.



Enjoy the Game of Life with real-time updates, and appreciate the power of TDD in delivering a reliable gaming experience!
