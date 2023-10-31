import java.net.*;
import java.io.*;

public class URLConnectionReader {
    public static void main(String[] args) {
        URL wiki = null;
        BufferedReader in = null;
        
        try{
            wiki = new URL("https://en.wikipedia.org/wiki/Computer_Network"); 
        
        }catch(MalformedURLException e){
            System.out.println("Cannot find webpage " + wiki);
            System.exit(-1);  // false termination
        }
        
        try{
            URLConnection aConnection = wiki.openConnection(); 
            //Returns a URLConnection instance that represents a connection to the remote object referred to by the URL.
            in = new BufferedReader(new InputStreamReader(aConnection.getInputStream()));
            
        }catch(IOException e){
            System.out.println("Cannot connect to the webpage " + wiki);
            System.exit(-1); // false termination
        }
        
        try{
            String lineOfWebpage;
            while((lineOfWebpage = in.readLine()) != null){
                System.out.println(lineOfWebpage);
            }
            in.close();
            
        }catch(IOException e){
            System.out.println("Cannot read from the webpage" + wiki);
        }
        
    }
}