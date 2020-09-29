package ca.carleton.comp.network;

import java.io.IOException;
import java.net.Socket;

public class ClientChannel {
    private Socket socket;

    public ClientChannel() {
        try {
            socket = new Socket("localhost", 3333);
            System.out.println("Connect to the game server success!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(byte[] message) throws IOException {
        socket.getOutputStream().write(message);
        socket.getOutputStream().flush();
    }

    public void write(String message) throws IOException {
        socket.getOutputStream().write(message.getBytes("UTF-8"));
        socket.getOutputStream().flush();
    }


    public String readString() throws IOException {
        byte[] data = new byte[1024];
        int len = socket.getInputStream().read(data);
        String message = new String(data,0,len);
        return message;
    }
}
