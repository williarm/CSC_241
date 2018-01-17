//----------------------------------------------------------------------
// TestFactorial.java         by Dale/Joyce/Weems              Chapter 3
//
// Repeatedly prompts user for a non-negative integer n.
// Outputs n! calculated recursively and iteratively.
// Uses a command line interface.
//----------------------------------------------------------------------
package ch03.apps;
import ch04.queues.*;
import ch04.threads.*;

import java.util.Scanner;

public class TestFactorial
{
	public static float factorialParallel(int n) throws InterruptedException{
		float result;
	    FactorialCounter c1 = new FactorialCounter();
	    FactorialCounter c2 = new FactorialCounter();
	    FactorialCounter c3 = new FactorialCounter();
	    FactorialCounter c4 = new FactorialCounter();
	    
	  
	    QueueInterface<Integer> q;
	    q = new SyncArrayBoundedQueue<Integer>(n);
	    
	    for (int i = 2; i <= n; i++)
	       q.enqueue(i);
	      
	    //Split up the numbers into 4 intervals
	    //n must be greater than or equal to 4.
	    
	    Runnable r1 = new IncreaseFactorial(c1, q);
	    Runnable r2 = new IncreaseFactorial(c2, q);
	    Runnable r3 = new IncreaseFactorial(c3, q);
	    Runnable r4 = new IncreaseFactorial(c4, q);
	    Thread t1 = new Thread(r1);
	    Thread t2 = new Thread(r2);
	    Thread t3 = new Thread(r3);
	    Thread t4 = new Thread(r4);

	    t1.start();  t2.start(); t3.start(); t4.start();
	    t1.join();   t2.join(); t3.join();  t4.join();
	    
	    //compute result here.

		return result;
	}
	
	
	public static float factorialParallelIdea(int n){
		float result = 1;
		//Thread1
		for(int i = n; i > (n - (n/4)); i--)
			result *= i;
		System.out.println("result for 100 to 76 = " + result);
		//Thread2
		for(int i = n - (n/4); i > (n - (n/2)); i--)
			result *= i;
		System.out.println("result for 75 to 51 = " + result);

		//Thread3
		for(int i = n - (n/2); i > (n - (3*n/4)); i--)
			result *= i;
		System.out.println("result for 50 to 26 = " + result);

		//Thread4
		for(int i = n - (3*n/4); i > 0; i--)
			result *= i;
		System.out.println("result for 25 to 1 = " + result);

		return result;
	}
	
	public static float factorialParallelRec(int n){
		float result = 1;
		result = factorial(n) / factorial(3*n/4);
		System.out.println("result for 100 to 76 = " + result);

		result *= factorial(3*n/4) / factorial(n/2);
		System.out.println("result for 75 to 51 = " + result);

		result *= factorial(n/2) / factorial(n/4);
		System.out.println("result for 50 to 26 = " + result);

		result *= factorial(n/4);
		System.out.println("result for 25 to 1 = " + result);

		return result;
	}
	
  private static float factorial(int n)
  // Precondition: n is nonnegative
  //
  // Returns the value of "n!"
  {
    if (n == 0)
      return (float) 1.0;
    else
      return (n * factorial (n - 1));
  }
   
  public static float factorial2(int n)
  // Precondition: n is nonnegative
  //
  // Returns the value of retValue: n!
  {
    float retValue = 1;     
    while (n != 0)
    {
      retValue = retValue * n;
      n = n - 1;
    }
  return(retValue);
  }
 
  public static void main(String[] args) throws InterruptedException
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("Factorial calculation test: "); 
    int n = 0;
    long timeStart, timeEnd;
    while (n >= 0)
    {
      System.out.print("\nEnter n (-1 to stop) > ");
      n = scan.nextInt();
      if (n >= 0)
      {
         System.out.println(n + "! is");
         System.out.println("\t recursive " + factorial(n));
         System.out.println("\t iterative " + factorial2(n));
         
         timeStart = System.nanoTime();
         String s = String.format("%.0f", factorialParallelIdea(n));
         timeEnd = System.nanoTime() - timeStart;
         System.out.println("\t iterative parallel idea " + s + " total time = " + timeEnd);
         
         timeStart = System.nanoTime();
         s = String.format("%.0f", factorialParallel(n));
         timeEnd = System.nanoTime() - timeStart;
         System.out.println("\t iterative parallel " + s + " total time = " + timeEnd);
         
         
         System.out.println("\t iterative parallel recursive " + factorialParallelRec(n));
      }
    }
  } 
}
































