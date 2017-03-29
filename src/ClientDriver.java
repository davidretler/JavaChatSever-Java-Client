import JavaChatClient.Client;

import java.io.IOException;

/**
 * Created by david on 3/29/17.
 */
public class ClientDriver {

    private static String ip = "127.0.0.1";
    private static int port = 4444;

    public static void main(String[] args) {

        Client myClient = new Client();

        myClient.connect(ip, port);

        try {
            System.out.println("Trying to send a message");
            myClient.send("hello");
            System.out.println("Sent a message");
            myClient.send("goodbye...");
            myClient.send("quit");
            myClient.send("test after closing");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
