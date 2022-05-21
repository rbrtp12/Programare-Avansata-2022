package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ClientThread extends Thread {
    private Socket socket = null ;
    private Server server = null;
    private ServerSocket serverSocket = null;
    public ClientThread (Socket socket, Server server, ServerSocket serverSocket){
        this.socket = socket ;
        this.server = server;
        this.serverSocket = serverSocket;
        server.whileIsRunning = true;
    }

    public void run () {
        try {
            String request;
            while(true){
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                request = in.readLine();
                PrintWriter out = new PrintWriter(socket.getOutputStream());

                if(request.equals("stop")){
                    server.isRunning = false;
                    System.exit(0);
                    serverSocket.close();

                    break;
                }else if(request.equals("exit")){
                    Server.whileIsRunning = false;
                    break;
                }

                if(socket.isConnected()){
                    System.out.println(request);
                    out.flush();
                }
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }
}