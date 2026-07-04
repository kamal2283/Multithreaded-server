import java.io.IOException;
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
                System.out.println("Connection accepted from: " + acceptedConnection.getInetAddress().getHostAddress());
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }

        }
    }

    public static void main(String[] args) {

    }
}