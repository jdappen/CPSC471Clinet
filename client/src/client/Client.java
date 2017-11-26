package client;


import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
       
        int portNum = 987;      //Port Number
        BufferedReader in;      //Input buffer
        PrintWriter out;        //Output writer
        
        String serverName = "localhost";  //The name of the server client wants to connect to deafault is localhost;
        String input;                     //The messages received from the Server
        String output;                    //The messages sent to the server (ls, get, put)
        


        //Input scanner 
        Scanner typed = new Scanner(System.in);
        
        //Sets the serverName to the command line arguments
        if(args.length != 0)
        {
            serverName = args[0];
            portNum =  Integer.parseInt(args[1]);
        }
        
        //Creates the Client socket to connect to the server
        Socket socket = new Socket( serverName, portNum);
        
        //Creates the input buffer and print writer
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        
        
        for(int i =0; i<1; i++)
        {
            System.out.println(in.readLine());
        }
        
        //Gets the command typed from user
        output = typed.nextLine();
        
        System.out.println(output);
        //sends command to server
        out.println(output);
        
        
        
    }
}
