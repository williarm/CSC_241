package ch04.threads;

import ch04.queues.QueueInterface;

public class IncreaseFactorial implements Runnable
{
   private FactorialCounter c;
   private QueueInterface<Integer> q;
   
   public IncreaseFactorial(FactorialCounter c, QueueInterface<Integer> q)
   {
      this.c = c;  this.q = q;
   }
   
   public void run()
   {
	  //String threadName = Thread.currentThread().getName();
  	  //System.out.println("Hello " + threadName);
      int hold;
      int count;
      while (!q.isEmpty())
      {
         hold = q.dequeue();   
         //System.out.println("hold = " + hold);
         c.multipleIncrement(hold);
      }
   }
}

