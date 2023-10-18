# Game of Life with Websockets

Welcome to the `GameOfLife` project. This is a modern implementation of John Conway's classic cellular automaton, with a twist - it utilizes WebSockets for delivering real-time game state updates.

## Features

- **Real-time Updates**: Using WebSockets, you can experience the Game of Life in real-time, with instantaneous state updates without any need for manual refreshes.
- **Test-Driven Development (TDD)**: This project has been developed following the principles of TDD, ensuring robustness and reliability. Every piece of code has been thoroughly tested before implementation, ensuring that the game functions as expected under various conditions.

## SetUp with Docker Compose

To run a `docker-compose` file, you need to have both Docker and Docker Compose installed on your system. Once you have those set up, you can use the `docker-compose` command to manage multi-container applications defined in a `docker-compose.yml` file.

***Once the service is running on your local machine you can play the sequence under localhost:5005***

Here's a basic step-by-step guide on how to run a `docker-compose` file:

1. **Navigate to the Directory**:
   Ensure you're in the directory where your `docker-compose.yml` file is located.

   ```bash
   cd /path/to/directory
   ```

2. **Start Services**:
   To start the services defined in `docker-compose.yml`, run:

   ```bash
   docker-compose up
   ```

   - If you want to start the services in detached mode (in the background), use:

     ```bash
     docker-compose up -d
     ```
  

3. **View Logs**:
   If you started the services in detached mode and want to view the logs:

   ```bash
   docker-compose logs
   ```

   To follow the logs:

   ```bash
   docker-compose logs -f
   ```

4. **Stop Services**:
   To stop the services:

   ```bash
   docker-compose down
   ```

   - If you also want to remove the volumes defined in the `docker-compose.yml` file, use:

     ```bash
     docker-compose down -v
     ```

5. **List Services**:
   To see a list of running services:

   ```bash
   docker-compose ps
   ```

6. **Rebuild Services**:
   If you made changes and need to rebuild the Docker images:

   ```bash
   docker-compose build
   ```

   Then start the services again using `docker-compose up`.

7. **Scaling Services**:
   If you want to scale a particular service (assuming it's designed to scale):

   ```bash
   docker-compose up --scale service_name=number_of_instances
   ```

   Replace `service_name` with the name of the service in your `docker-compose.yml` and `number_of_instances` with the number of instances you want to run.

These are basic commands to get started with `docker-compose`. There are many other commands and options available, so it's beneficial to refer to the official documentation or run `docker-compose --help` for more details.

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
