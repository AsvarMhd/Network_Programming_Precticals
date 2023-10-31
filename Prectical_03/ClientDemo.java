
import java.io.IOException;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ClientDemo {
    
    public static void main(String[] args) throws IOException {
        final String SERVER_ADDRESS = "localhost";
        final int SERVER_PORT = 8080;
        
        try(Socket socket = new Socket(SERVER_ADDRESS,SERVER_PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            
            String response = in.readLine();
            System.out.println("Server response : " + response);
        
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
}