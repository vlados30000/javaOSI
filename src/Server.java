import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        System.out.println("Server startup");
        int port = 5566;

        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept(); // ждем подключения
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            System.out.printf("New connection accepted. Port: %d%n", clientSocket.getPort());
            final String name = in.readLine();
            out.println(String.format("Hello %s, yours port %d", name, clientSocket.getPort()));
        }
    }
}