import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * Server
 */
public class Server {

    public void run() {

        int port = 8010;
        ServerSocket socket = null;
        try {
            socket = new ServerSocket(port);
            socket.setSoTimeout(10000);
        } catch (IOException ex) {
            System.out.println("Error setting timeout: " + ex.getMessage());
        }
        while (true) {

            try {

                System.out.println("Server is running on port: " + port);
                Socket acceptedConnection = socket.accept();

                // Print the IP address of the client that connected
                System.out.println("Connection accepted from: " + acceptedConnection.getInetAddress().getHostAddress());

                // Create a PrintWriter to send data to the client
                PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream());

                // Create a BufferedReader to read data from the client
                BufferedReader fromClient = new BufferedReader(
                        new InputStreamReader(acceptedConnection.getInputStream()));
                toClient.println("Hello from the server!");
                toClient.close();
                fromClient.close();
                acceptedConnection.close();

            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }

        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.run();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

// 4:02:52