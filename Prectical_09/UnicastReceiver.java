import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class UnicastReceiver {
     public static void main(String[] args) {
        try {
            int receiverport = 12345;
            
            ServerSocket serversocket = new ServerSocket(receiverport);
            Socket socket = serversocket.accept();
            
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String msg = reader.readLine();
            System.out.println("Received : " + msg);
            
            
            socket.close();
            serversocket.close();
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
