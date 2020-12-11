import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public Client() {
        start();
    }

    private void start() {
        try {
            System.out.println("Client is up and running...");
            socket = new Socket("127.0.0.1", 8443);
            System.out.println("Socket info: " + socket);

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    while (true) {
                        String message = in.readUTF();
                        System.out.println(new Date() + ": " + message);
                    }
                } catch (EOFException e) {
                    System.out.println("Server is unavailable. Connection closed.");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    close();
                }
            }).start();

            Scanner scanner = new Scanner(System.in);
            while (true) {
                String message = scanner.nextLine();
                if (socket.isClosed()) {
                    System.out.println("Closed");
                    break;
                }
                out.writeUTF(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    private void close() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
