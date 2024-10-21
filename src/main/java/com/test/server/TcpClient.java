import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {

    public static void sendRequest(String serverIp) {
        try (Socket socket = new Socket(serverIp, 8080)) {
            OutputStream output = socket.getOutputStream();
            String message = "Hello Server";
            output.write(message.getBytes());
        } catch (IOException ex) {
            System.out.println("Client exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
