import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class MultiThreadedNonBlockingServer {

    public static void main(String[] args) throws IOException {
        // Create a server socket channel and configure it as non-blocking
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);

        // Bind the server socket to a specific address and port
        serverSocketChannel.socket().bind(new InetSocketAddress("localhost", 8080));

        // Create a selector
        Selector selector = Selector.open();

        // Register the server socket channel with the selector for accepting connections 
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("Server started on port 8080");

        while (true) {
            // Wait for events
            selector.select();

            // Get the selected keys (events)
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();

                if (key.isAcceptable()) {
                    // Accept a new connection
                    ServerSocketChannel serverChannel = (ServerSocketChannel) key.
                            channel();
                    SocketChannel clientChannel = serverChannel.accept();
                    clientChannel.configureBlocking(false);

                    // Register the new client channel for reading
                    clientChannel.register(selector, SelectionKey.OP_READ);

                    System.out.println("Accepted connection from: " + clientChannel.getRemoteAddress());
                } else if (key.isReadable()) {
                    // Read data from the client
                    SocketChannel clientChannel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int bytesRead = clientChannel.read(buffer);

                    if (bytesRead == -1) {
                        // Connection closed by the client
                        key.channel().close();
                        key.cancel();
                    } else if (bytesRead > 0) {
                        buffer.flip();
                        byte[] data = new byte[buffer.remaining()];
                        buffer.get(data);
                        String message = new String(data);

                        System.out.println("Received from " + clientChannel.
                                getRemoteAddress() + ": " + message);
                    }
                }

                // Remove the key from the selected set, as we've processed it
                keyIterator
                        .remove();

            }

        }

    }

}