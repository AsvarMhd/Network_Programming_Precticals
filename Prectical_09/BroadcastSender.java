import java.io.*;
import java.net.*;

public class BroadcastSender {
    public static void main(String[] args) {
        
        try {
            InetAddress broadcastIP = InetAddress.getByName("255.255.255.255");
            int broadcastPort = 12345;
            
            DatagramSocket socket = new DatagramSocket();
            
            String msg = "Hiiii... Broadcastians";
            byte[] data = msg.getBytes();
            DatagramPacket packet = new DatagramPacket(data,data.length,broadcastIP,broadcastPort);
            socket.send(packet);
            
            socket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}