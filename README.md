# Multithreaded Web Server in Java

This repository contains two small Java socket server examples that demonstrate the difference between a single-threaded server and a multithreaded server.

Both versions listen on port `8010`, accept TCP socket connections from a local client, and send a short text response back to the caller. The multithreaded version handles each connection in its own thread, while the single-threaded version processes connections one at a time.

## Project Structure

```text
MultiThreaded/
  Client.java
  Server.java
SingleThreaded/
  Client.java
  Server.java
```

## What Each Version Does

### MultiThreaded

The multithreaded server accepts incoming connections and starts a new `Thread` for each client socket. The matching client creates 100 threads and opens 100 connections to the local server.

Server behavior:

- Listens on `localhost:8010`
- Accepts client sockets in an infinite loop
- Spawns a new worker thread for each connection
- Sends `Hello from server` to the client

Client behavior:

- Connects to `localhost:8010`
- Sends a short greeting message
- Reads one response line from the server
- Prints the response to the console
- Starts 100 client threads

### SingleThreaded

The single-threaded server accepts one connection at a time and handles it directly on the main loop thread. The client opens one connection, sends a greeting, and prints the server response.

Server behavior:

- Listens on `localhost:8010`
- Accepts one client at a time in sequence
- Sends `Hello from the server!` to the client
- Closes the socket after responding

Client behavior:

- Connects to `localhost:8010`
- Sends `Hello from the client!`
- Reads the server response
- Prints the response to the console

## Requirements

- Java Development Kit (JDK) 8 or newer
- A terminal or command prompt
- Two separate terminal windows or tabs, one for the server and one for the client

## How To Run

The project does not use Maven or Gradle. Compile and run the classes directly with `javac` and `java`.

### Run the multithreaded example

From the repository root:

```bash
javac MultiThreaded/Server.java MultiThreaded/Client.java
java -cp MultiThreaded Server
```

In a second terminal:

```bash
java -cp MultiThreaded Client
```

### Run the single-threaded example

From the repository root:

```bash
javac SingleThreaded/Server.java SingleThreaded/Client.java
java SingleThreaded.Server
```

In a second terminal:

```bash
java SingleThreaded.Client
```

## Expected Output

### Multithreaded server

Server console:

```text
Server is running on port8010
```

Client console:

```text
Response from Server Hello from server
```

Because the client starts 100 threads, you should see the response printed many times.

### Single-threaded server

Server console:

```text
Server is running on port: 8010
Connection accepted from: 127.0.0.1
```

Client console:

```text
Received from server: Hello from the server!
```

## Notes

- Both examples use the same port, so run only one server at a time.
- If port `8010` is already in use, stop the process using it or change the port in both the server and client files.
- The servers are intentionally simple and are meant for learning basic socket programming and concurrency concepts.

## Learning Goals

This project is useful for understanding:

- Basic TCP socket communication in Java
- Reading and writing with `Socket`, `ServerSocket`, `BufferedReader`, and `PrintWriter`
- The difference between sequential request handling and per-connection threading
- How concurrency affects server throughput and responsiveness

## License

No license file is included in this repository.
