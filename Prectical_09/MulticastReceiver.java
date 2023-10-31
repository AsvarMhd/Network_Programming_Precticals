import java.net.*;
import java.io.*;

public class MulticastReceiver {
    public static void main(String[] args) {
        try {
            InetAddress groupIP = InetAddress.getByName("224.0.0.1");
            int groupPort = 12345;
            
            MulticastSocket socket = new MulticastSocket(groupPort);
            socket.joinGroup(groupIP);
            
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
            socket.receive(packet);
            
            String msg = new String(packet.getData(),0,packet.getLength());
            System.out.println("Received : " + msg);


            socket.leaveGroup(groupIP);
            
            socket.close();
               
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
