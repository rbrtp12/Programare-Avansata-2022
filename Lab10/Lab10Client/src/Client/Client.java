package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main (String[] args) throws IOException {

        String serverAddress = "127.0.0.1";
        int PORT = 8100;
        Socket socket = new Socket(serverAddress, PORT);
        Scanner scan= new Scanner(System.in);
        try{
            String request;
            PrintWriter out =
                    new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream()));

            while(scan.hasNext()){

                request =  scan.nextLine();
                if(request.equals("exit")){
                    out.println(request);
                    socket.close();
                    break;

                }else if(request.equals("stop")){
                    out.println(request);
                    socket.close();
                    break;
                }
                if(socket.isConnected()){
                    out.println(request);

                }

            }

        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}