import java.net.Socket;

public class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        System.out.println("New client connected");
        // Logika przetwarzania żądania TCP
    }
}