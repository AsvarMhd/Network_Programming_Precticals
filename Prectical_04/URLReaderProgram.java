import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class URLReaderProgram {
    
    public static void main(String[] args) {
        
        URL wiki = null;
        
        try{
            wiki = new URL("https://en.wikipedia.org/wiki/Computer_Network");
            
            InputStream stream = wiki.openStream();  // data types derieved from classes (like String)
            //return type of openstream() method is InputStream that's why it is taken as the data type
            // openStream() is declared in URL 
            InputStreamReader instream = new InputStreamReader(stream); // to read inputstream we need InputStreamReader object that is created to its class
            BufferedReader in = new BufferedReader(instream); //to read as buffer we need to pass above object here
            // bufeeredRedaer needs inputsteream to read as buffer, to get inputstream openStream() is needed
            
            //BufferedReader in = new BufferedReader(new InputStreamReader(wiki.openStream()));
            
            String lineOfWebpage;
            while((lineOfWebpage = in.readLine()) != null){
                System.out.println(lineOfWebpage);    
            }
            in.close();
            
        }catch(MalformedURLException e){
            System.out.println("Cannot find webpage " + wiki);
        } catch (IOException e) {
            System.out.println("Cannot read from webpage " + wiki);
        }
    }
}