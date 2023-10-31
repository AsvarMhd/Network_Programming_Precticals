import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;


public class UnicastSender {
    public static void main(String[] args) {
        try{
            InetAddress reeceiverIP =  InetAddress.getByName("localhost");
            int inetreceiverport = 12345;
            
            Socket socket = new Socket(reeceiverIP,inetreceiverport);
            
            OutputStream out = socket.getOutputStream();
            PrintWriter writer  = new PrintWriter(out);
            writer.println(" Gotcha ...");
            writer.flush();
            
            socket.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}