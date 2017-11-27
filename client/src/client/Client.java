package client;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import  java.io.InputStream;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;

public class Client {

    public static void main(String[] args) throws IOException {
       
        int portNum = 987;      //Port Number
        BufferedReader in;      //Input buffer
        PrintWriter out;        //Output writer
        
        String serverName = "localhost";  //The name of the server client wants to connect to deafault is localhost;
        String input;                     //The messages received from the Server
        String output;                    //The messages sent to the server (ls, get, put)
        String command[] = new String[2];


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
        
        command = output.split(" ");
        
        if("ls".equals(command[0]))
        {
            list();
        }
        else if("get".equals(command[0]))
        {
            download(command[1], socket);
        }
        else if("put".equals(command[0]))
        {
            upload(command[1]);
        }
        
    }
    
    public static void download( String message, Socket socket) throws IOException
    {
        
        int count;
       InputStream in =socket.getInputStream();
       
       OutputStream out = new FileOutputStream(message);
       
       byte data[] = new byte[16*1024];
       
       while((count = in.read(data)) > 0)
       {
           out.write(data, 0, count);
       }
        
        
        
        
        
        
        
//        int bytesRead;
//        int counter = 0;
//        byte byteArray[] = new byte[99999999];
//        InputStream IS = socket.getInputStream();
//        FileOutputStream fileOut = new FileOutputStream(message);
//        BufferedOutputStream bufOut = new BufferedOutputStream(fileOut);
//        bytesRead = IS.read(byteArray, 0, byteArray.length);
//        counter = bytesRead;
//        do{
//            bytesRead = IS.read(byteArray, counter, (byteArray.length- counter));
//            if(bytesRead >= 0)
//            {
//                counter += bytesRead;
//            }
//        }while(counter > -1);
//        
//        bufOut.write(byteArray, 0, counter);
//        bufOut.flush();
        
    }
    
    
    public static void upload(String message)
    {
        
    }
    
    public static void list()
    {
        
    }
    
}
