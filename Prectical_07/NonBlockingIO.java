import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class NonBlockingIO {

    public static void main(String[] args) {
        
        String sourceFile = "D:\\Aswar\\Old.txt";
        String destinationFile = "D:\\Aswar\\New02.txt";

        try {
            long startTime = System.currentTimeMillis();

            Path sourcePath = Paths.get(sourceFile);
            FileChannel sourceChannel = FileChannel.open(sourcePath,
                    StandardOpenOption.READ);

            Path destinationPath = Paths.get(destinationFile);
            FileChannel destinationChannel = FileChannel.open(destinationPath, 
                    StandardOpenOption.CREATE, 
                    StandardOpenOption.WRITE,
                    StandardOpenOption.TRUNCATE_EXISTING);

            ByteBuffer buffer = ByteBuffer.allocate(4096);

            while (sourceChannel.read(buffer) != -1) {
                buffer.flip();
                destinationChannel.write(buffer);
                buffer.clear();
            }

            sourceChannel.close();
            destinationChannel.close();

            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            System.out.println("File copied successfully.");
            System.out.println("Time taken: " + duration + " milliseconds");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
