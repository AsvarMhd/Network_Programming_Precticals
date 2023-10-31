import java.net.*;
import java.io.*;
import java.util.Scanner;

public class PacketClientProgram {

    private static int INPUT_BUFFER_LIMIT = 500;
    private InetAddress localHost;

    public PacketClientProgram() {
        try {
            localHost = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            System.out.println("CLIENT: Error connecting to network");
            System.exit(-1);
        }
    }

    private void sendingMSG(String userName) {
        DatagramSocket socket = null;
        String un = userName;
        String msg = "My index number is "+un;
        //System.out.println(msg);
        
        try {
            socket = new DatagramSocket();
            byte[] sendBuffer = msg.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer,
                    sendBuffer.length, localHost,
                    PacketServer.SERVER_PORT);
            System.out.println("CLIENT: Sending the request to server");
            socket.send(sendPacket);
        } catch (IOException e) {
            System.out.println("CLIENT: Error sending the request to server");
        }
        try {
            byte[] receiveBuffer = new byte[INPUT_BUFFER_LIMIT];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer,
                    receiveBuffer.length);
            socket.receive(receivePacket);

            System.out.println("Resopnse : " + new String(
                    receivePacket.getData(), 0,
                    receivePacket.getLength()));
        } catch (IOException e) {
            System.out.println("CLIENT: Cannot receive from server");
        }
        socket.close();
    }

    private static void Delay() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) {
        
        Scanner myObj = new Scanner(System.in);
        String userName;

        System.out.println("Enter username");
        userName = myObj.nextLine();

        PacketClientProgram c = new PacketClientProgram();
        Delay();
        c.sendingMSG(userName);

    }
}
