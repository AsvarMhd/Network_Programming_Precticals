import java.lang.InterruptedException;

public class SummationThread extends Thread{
 
    int start;
    int end;
    int result;
    int tno;
    public void getValue(int start, int end, int tno){
        
        this.start = start;
        this.end = end;
        this.tno = tno;
    }
    
    @Override
    public void run(){
        result = 0;
        for(int i=start; i<=end; i++){
            result += i;
            try{
		Thread.sleep(500);
            }catch(InterruptedException e){
            }
            
        }
        System.out.println("Sum of Thread " + tno+ " : " + result);
    }  
}