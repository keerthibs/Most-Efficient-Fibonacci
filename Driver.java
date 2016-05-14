
/** 
 *  @author Keerthi BS, Monish
 *  @date 02/19/2016
 *
 *  @Driver.java Driver Program for calling the Fibonacci methods
 *
 *  @Description
 *      Contains just the main method that calls the Fibonacci functions
 */


public class Driver {
    public static void main(String[] args) {
        long start, stop, OnTimer, OLogNtimer, FibonacciNumber1, FibonacciNumber2;

       Timer timer=new Timer();
       timer.start();
        FibonacciNumber1 = FibonacciNumber.FibonacciOn(1000000);
       timer.end();
       System.out.println("O(n)\nValue " + FibonacciNumber1);
       System.out.println(timer);

       timer.start();
        FibonacciNumber2 = FibonacciNumber.FibonacciOLogN(1000000);
        timer.end();
                
        System.out.println("O(log n)\nValue " + FibonacciNumber2);
        System.out.println(timer);
    }
}