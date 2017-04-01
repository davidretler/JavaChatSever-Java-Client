import JavaChatClient.Client;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by david on 3/29/17.
 */
public class ClientDriver {

    private static String ip = "127.0.0.1";
    private static int port = 4444;

    public static void main(String[] args) {

        Client myClient = new Client();

        myClient.connect(ip, port);


        // create thread to listen for message asynchronously
        new Thread(new Runnable() {
            @Override
            public void run() {
             while(true) {
                 try {
                     String message = myClient.receive();
                     System.out.println("Received message: " + message);
                 } catch (IOException e) {
                     e.printStackTrace();
                     System.err.println("IOException when attempting to receive a message from server. Likely a closed connection");
                     break;
                 }
             }
            }
        }).start();


        // send all inputs to server
        Scanner in = new Scanner(System.in);

        while(true) {
            String line = in.nextLine();
            System.out.println("Attempting to send \"" + line + "\" to server.");

            try {
                myClient.send(line);
            } catch(IOException e) {
                e.printStackTrace();
                System.err.println("IOException when attempting to send a message to server. Likely a closed connection");
                break;
            }
        }
    }

}
