package chat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ServerChat implements Chat {
    private ServerSocket serverSocket;
    private Set<ClientHandler> clients;
    private AuthenticationService authenticationService;

    public ServerChat() {
        start();
    }

    @Override
    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }

    private void start() {
        try {
            serverSocket = new ServerSocket(8888);
            clients = new HashSet<>();
            authenticationService = new AuthenticationService();

            while (true) {
                System.out.println("Server is waiting for a connection ...");
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket, this);
                System.out.println(String.format("[%s] Client[%s] is successfully logged in", new Date(), clientHandler.getName()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void broadcastMessage(String message) { //Отправка сообщения всем пользователям
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }

    @Override
    public boolean isNicknameOccupied(String nickname) { //Проверка на
        for (ClientHandler client : clients) {
            if (client.getName().equals(nickname)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void privateMesssage(String message) {
        String[] credentials = message.split("\\s");
        String nickname = credentials[1];
        String pm = "";
        credentials[0] = "Whisper: ";
        for (int i = 0; i < credentials.length; i++) {
            pm = pm + credentials[i] + " ";
        }

        for (ClientHandler c : clients) {
            if (c.getName().equals(nickname)) c.sendMessage(pm);
        }
    }

    @Override
    public void subscribe(ClientHandler client) {
        clients.add(client);
    }

    @Override
    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }
}
