import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.OutputStream;


public class Server {
    
    public static void main(String[] args) {
        
        final int port = 8000; // server port
        
        
        ServerSocket serversocket; // instance of ServerSocket class
        
        try {
            serversocket = new ServerSocket(port); // 
            System.out.println(serversocket); // displays address and the port as the content of the ServerSocket instance
            
            while(true){
                Socket clientsocket = serversocket.accept();
                
                ClientHandler clienthandler = new ClientHandler(clientsocket);    
                Thread clientthread = new Thread(clienthandler);
                clientthread.start();
                
                ServerHandler serverhandler = new ServerHandler();
                Thread serverthread = new Thread(serverhandler);
                serverthread.start();
            }
            
        } catch (IOException e) {
            System.out.println(" Cannot open a connection ");
        }
        
    }
        
}