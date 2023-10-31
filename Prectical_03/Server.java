
import java.net.ServerSocket;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


public class Server {
    
    public static void main(String[] args) {
        
        final int PORT = 8080;
        
        try (ServerSocket serversocket = new ServerSocket(PORT)){
            System.out.println("Server started. Listning on port " + PORT);
            
            while(true){
                Socket clientsocket = serversocket.accept();
                System.out.println("New client connected : " + clientsocket.getInetAddress());
                
                Thread clientThread = new Thread(new ClientHandler(clientsocket));
                clientThread.start();
            }
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

class ClientHandler implements Runnable{
    
    private Socket clientsocket;
    
    public ClientHandler(Socket clientsocket){
        this.clientsocket = clientsocket;
    }
    
    public void run(){
        try(PrintWriter out = new PrintWriter(clientsocket.getOutputStream(), true)){
            
            out.println("Hello, client! This is the response from the server");
            
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try{
                clientsocket.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        
    }
}
