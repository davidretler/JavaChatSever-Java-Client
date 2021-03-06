package JavaChatClient;

import java.io.*;
import java.net.Socket;

/**
 * Created by david on 3/29/17.
 */
public class Client {

    private Socket connection;
    private PrintWriter out;
    private BufferedReader in;

    public Client() {
    }

    public void connect(String ip, int port) {
        try {
            connection = new Socket(ip, port);
            out = new PrintWriter(connection.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String message) throws IOException {
        if(connection == null) {
            throw new IllegalStateException("There is no connection...");
        }
        out.println(message);
    }

    public String receive() throws IOException {
        if(connection == null) {
            throw new IllegalStateException("There is no connection...");
        }

        String message = in.readLine();
        if(message == null) throw new IOException();
        return message;
    }

}
