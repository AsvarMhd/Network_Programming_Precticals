
public class Task02 implements Runnable{ // implementing a Runnable interface 
    
    public void run(){   // defining the run() method
        
        System.out.println("My second thread application"); // what thread does
    
    }
    
    public static void main(String[] args) {
        
        //Task02 tr1 = new Task02();
        //Thread tr2 = new Thread(tr1);
        
        Thread tr2 = new Thread(new Task02()); // passing a object parameter to Thread class
        
        tr2.start(); // calling start() method through created object to create a thread 
    }
    
}