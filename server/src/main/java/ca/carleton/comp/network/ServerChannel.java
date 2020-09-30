package ca.carleton.comp.network;

import java.io.IOException;
import java.net.Socket;

public class ServerChannel {
    private int playerId;
    private Socket socket;

    public ServerChannel(int playerId, Socket socket) {
        this.playerId = playerId;
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void write(String message) throws IOException {
        this.socket.getOutputStream().write(message.getBytes("UTF-8"));
        this.socket.getOutputStream().flush();
    }

    public String read() throws IOException {
        byte[] data = new byte[1024];
        int len = socket.getInputStream().read(data);
        if (len > 0) {
            String message = new String(data, 0, len);
            return message;
        }
        return "";
    }
}
