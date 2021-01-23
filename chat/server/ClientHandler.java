package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private String name;
    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;
    private Chat chat;
    private final int UNIX_TIME = 1000;
    private final int AUTH_TIME_MAX = 120; // 1 = 1 sec

    public ClientHandler(Socket socket, Chat chat) {
        this.socket = socket;
        this.chat = chat;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            throw new RuntimeException("SWW", e);
        }

        listen();
    }

    public String getName() {
        return name;
    }

    private void listen() {
        new Thread(() -> {
            checkAuthTime();
            doAuth();
            receiveMessage();
        }).start();
    }

    private synchronized void checkAuthTime() {
        long currentTime = System.currentTimeMillis() / UNIX_TIME;

        new Thread(new Runnable() {
            @Override
            public void run() {
                sendMessage(String.format("[INFOMATION]: You have only %s sec to enter correct login password! Or connection will be closed", AUTH_TIME_MAX));
                while ((System.currentTimeMillis() / UNIX_TIME - currentTime) <= AUTH_TIME_MAX) ;
                if (!true) {
                    try {
                        sendMessage("[INFORMATION]: Connection closed");
                        socket.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void doAuth() {
        sendMessage("Please enter credentials. Sample [-auth login password]");
        try {
            /**
             * -auth login password
             * sample: -auth l1 p1
             */
            while (true) {
                String mayBeCredentials = in.readUTF();
                if (mayBeCredentials.startsWith("-auth")) {
                    String[] credentials = mayBeCredentials.split("\\s");
                    String mayBeNickname = chat.getAuthenticationService()
                            .findNicknameByLoginAndPassword(credentials[1], credentials[2]);
                    if (mayBeNickname != null) {
                        if (!chat.isNicknameOccupied(mayBeNickname)) {
                            sendMessage("[INFO] Auth OK");
                            name = mayBeNickname;

                            chat.broadcastMessage(String.format("[%s] logged in", name));
                            chat.subscribe(this);

                            return;
                        } else {
                            sendMessage("[INFO] Current user is already logged in.");
                        }
                    } else {
                        sendMessage("[INFO] Wrong login or password.");
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("SWW", e);
        }
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException("SWW", e);
        }
    }

    public void receiveMessage() {
        while (true) {
            try {
                String message = in.readUTF();
                if (message.startsWith("-")) {
                    if (message.startsWith("-exit")) {
                        chat.unsubscribe(this);
                        chat.broadcastMessage(String.format("[%s] logged out", name));
                        break;
                    }

                    if (message.startsWith("-chnick")) {
                        //-chnick name
                        String[] credentials = message.split("\\s");
                        String oldNick = this.name;
                        String newNick = credentials[1];
                        if (!chat.isNicknameOccupied(newNick)) {
                            chat.getAuthenticationService().changeNickname(newNick, oldNick);
                            name = newNick;
                            chat.broadcastMessage(String.format("[%s] changed nickname to [%s]", oldNick, newNick));
                        } else {
                            System.out.println("[INFO] Current user is already logged in.");
                        }
                    }
                } else chat.broadcastMessage(String.format("[%s]: %s", name, message));
            } catch (IOException e) {
                throw new RuntimeException("SWW", e);
            }
        }
    }
}
