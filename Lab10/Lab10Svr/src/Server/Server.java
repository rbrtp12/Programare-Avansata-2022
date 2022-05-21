package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 8100;
    public boolean isRunning = true;
    public static boolean whileIsRunning = true;

    public Server() throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            while (isRunning) {

                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();

                ClientThread clientThread = new ClientThread(socket,this,serverSocket);
                clientThread.start();
                while(whileIsRunning){
                    Thread.sleep(1000);
                }
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Ooops... " + e);
        }
    }
}