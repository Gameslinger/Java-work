import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        String ip = "127.0.0.1";
        int port = 4444;
        
        
        try{
        Socket client = new Socket(ip,port); 
    InputStream fromserver = client.getInputStream();
    DataInputStream in = new DataInputStream(fromserver);
    OutputStream toserver = client.getOutputStream();
      DataOutputStream out = new DataOutputStream(toserver);
    while(true){
     
        
        System.out.println("Server: "+ in.readUTF());
        System.out.print("you: ");
         Scanner send = new Scanner(System.in);
         out.writeUTF(send.nextLine());
    }

        }catch(Exception e){
          //server disconnected
            System.out.println("The server disconnected.");
            System.exit(1);
        }
    }
    
}
