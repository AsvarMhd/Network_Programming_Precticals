import java.net.*;
import java.io.*;

public class MulticastSender {
    public static void main(String[] args) {
        try {
            InetAddress groupIP = InetAddress.getByName("224.0.0.1");
            int groupPort = 12345;
            
            MulticastSocket socket = new MulticastSocket(groupPort);
            socket.joinGroup(groupIP);
            
            String msg = " Hiiii... Multicastians ";
            byte[] data = msg.getBytes();
            DatagramPacket packet = new DatagramPacket(data,data.length,groupIP,groupPort);
            socket.send(packet);
            
            socket.leaveGroup(groupIP);
            
            socket.close();
               
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
