package ReadStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class ReadStream {
    
    public static void main(String[] args) {      
        try {
            BufferedInputStream reader =  
                    new BufferedInputStream(new FileInputStream("C:\\Users\\precticals\\01.txt"));
            
            byte[] chunk = new byte[5];
            int readBytes;
            int remainingBytes = reader.available();
            
            while((readBytes = reader.read(chunk))>0){
                System.out.println(new String (chunk,0,readBytes));
                remainingBytes = remainingBytes - readBytes;
                System.out.println("Remaining Bytes : " + remainingBytes);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}