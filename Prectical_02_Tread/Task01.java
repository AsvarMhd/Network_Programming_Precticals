
public class Task01 extends Thread{ //declare Task01 class as a inherited child class of Thread class
    
    public void run(){   // Overriding the run() method of Thread class by run() method of Task01
        
        System.out.println("My first thread applicaiton");  // what created thread does
    
    }
    
    public static void main(String[] args) {
        
        Task01 tr1 = new Task01(); // creating an object for Task01 class
        
        tr1.start(); // calling start() method through object to create a thread  
    
    }
}