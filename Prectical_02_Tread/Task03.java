
public class Task03 extends Thread {

    public void run() {
    }

    public static void main(String[] args) {
        if (args.length > 0) {                     // checking if the argument has a value or null
            
            if (Integer.parseInt(args[0]) < 0) {   // checking if the value is positive or not
                System.err.println(args[0] + " must be >= 0.");  // error message
            } else {

                Sum sumObject = new Sum();  //object is cretaed for Sum class

                int upper = Integer.parseInt(args[0]); // value of argument is converted into int and assigned to upper varouble

                Thread thrd = new Thread(new Summation(upper, sumObject)); //object is created to Thread class and object parameter is passed 

                thrd.start();   // calling start() method to create a thread

                try {

                    thrd.join();   // join() method is used when 2 independent thread are run 

                    System.out.println("The sum of " + upper + " is " + sumObject.getSum());   // output message, getSum() method from Sum class is called

                } catch (InterruptedException e) {
                }

            }
        } else {
            System.err.println("Usage: Summation <integer value>");  // error message
        }
    }
}


class Sum {

    private int sum;

    public int getSum() { // method to return sum to line 28
        return sum;
    }

    public void setSum(int sum) {  // method to assign sum value of the thread into here at line 74
        this.sum = sum;
    }
    
}


class Summation implements Runnable {  // Runnbale interface is implemented from SUmmation class

    private int upper;  // global int type private variouble upper
    Sum sumValue;    // global variouble sumvalue 

    public Summation(int upper, Sum sumValue) { //Constructor with pramters passed in line 19

        this.upper = upper;          // assigning parameter value to global upper variouble
        this.sumValue = sumValue;    // assigning parameter value to global sumValue variouble

    }

    public void run() {     // run method that creates thread

        int sum = 0;   
        for (int i = 0; i <= upper; i++) {   // loop that runs number of rounds as given in the args 
            sum += 1;
        }
        sumValue.setSum(sum);    // pass new sum into setSum() method of 
        
    }
}