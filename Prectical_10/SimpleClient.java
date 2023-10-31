import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SimpleClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        // Create a socket channel and connect to the server
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8080));

        // Send a message to the server
        String message = "Hello, Server!";
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
        socketChannel.write(buffer);
        System.out.println("Sent: " + message);

        // Read the server's response
        ByteBuffer responseBuffer = ByteBuffer.allocate(1024);
        int bytesRead = socketChannel.read(responseBuffer);
        if (bytesRead > 0) {
            responseBuffer.flip();
            byte[] responseData = new byte[responseBuffer.remaining()];
            responseBuffer.get(responseData);
            String responseMessage = new String(responseData);
            System.out.println("Received: " + responseMessage);
        }

        // Close the socket channel
        socketChannel.close();
    }
}
