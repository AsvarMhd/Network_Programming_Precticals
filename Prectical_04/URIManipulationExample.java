import java.net.URI;
import java.net.URISyntaxException;

public class URIManipulationExample {
    public static void main(String[] args) {
        try{
            String uriString = "https://en.wikipedia.org/wiki/Computer_network";
            URI uri = new URI(uriString);
            
            //Modify the URI components
            URI modifiedURI = uri.resolve("newPath"); //Resolve a relative URI against the base URI
            System.out.println("Modified URI : " + modifiedURI);
            
            //create a new URI
            URI newURI = new URI("https","www.example.com","/newpath","param=value","fragment");
            System.out.println("New URI : " + newURI);
            
        }catch(URISyntaxException e){
            e.printStackTrace();
        }
    }
}
