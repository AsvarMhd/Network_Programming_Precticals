import java.io.*;
import java.net.*;

public class BoradcastReceiver {
    public static void main(String[] args) {
        try {
            int broadcastPort = 12345;
            
            DatagramSocket socket = new DatagramSocket(broadcastPort);
  
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
            socket.receive(packet);
            String msg = new String(packet.getData(),0,packet.getLength());
            System.out.println(" Receive : " + msg);
            
            socket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
