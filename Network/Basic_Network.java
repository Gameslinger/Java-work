import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Network extends Thread {
    ServerSocket serverSocket;

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(4444);
        }
        catch (Exception e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
        
        while(true) {
            try {
                Socket server = serverSocket.accept();
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                DataInputStream in = new DataInputStream(server.getInputStream());
                out.writeUTF("What you you like to do or help(help)");
                while(true) {
                    String client;
                    
                    switch (client = in.readUTF()) {
                        case "rev": {
                            out.writeUTF("What to reverse?");
                            String mess = in.readUTF();
                            String reverse = "";
                            for (int i = mess.length() - 1; i != 0; --i) {
                                reverse = reverse + mess.charAt(i);
                            }
                            reverse = reverse + mess.charAt(0);
                            out.writeUTF("Its reverse is: " + reverse);
                            break;
                        }
                        case "lv": {
                            out.writeUTF("Good Bye");
                     
                            server.close();
                            break;
                        }
                        case "kill": {
                            out.writeUTF("Server shutting down...");
                            System.exit(1);
                            break;
                        }
                        case "help": {
                            out.writeUTF("I can: reverse String(rev), leave(lv), die(kill)");
                            break;
                        }
                        default:
                           out.writeUTF("Sorry what was that?"); 
                    }
                    
                }
            }
            catch (Exception e) {
                System.out.println("Error");
            }
            
        }
    }

    public static void main(String[] args) throws Exception {
        try {
            Network t = new Network();
            t.start();
        }
        catch (Exception e) {
            System.out.println("It broke...");
            System.exit(1);
        }
    }
}
