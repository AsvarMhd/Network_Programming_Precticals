import java.util.Scanner;

public class GetSummation {
    
    public static void main(String[] args) {
        
        Scanner variable = new Scanner(System.in);
        System.out.println("Enter the non-negative integer: ");
        int n = variable.nextInt();
        
//getting the mid point
        int point = n/3;
		//creating 3 threads
        SummationThread threadobj01 = new SummationThread();
        SummationThread threadobj02 = new SummationThread();
        SummationThread threadobj03 = new SummationThread();
        
        threadobj01.start();
        threadobj02.start();
        threadobj03.start();
        
        threadobj01.getValue(1, point,1);
        threadobj02.getValue(point+1, (2*point),2);
        threadobj03.getValue(((2*point)+1), n,3);
        
        try {
            // Wait for both threads to finish
            //stop continue the program until both threads update their result
            threadobj01.join();
            threadobj02.join();
            threadobj03.join();
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        //calling non-static methods in a static method.
        int finalResult = threadobj01.result + threadobj02.result + threadobj03.result; 
        System.out.println("Summation is : " + finalResult);  
    }
}
