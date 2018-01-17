package ch04.threads;

public class FactorialCounter {
	private float count;
  
	public FactorialCounter()
	{
		count = 1;
	}

	public synchronized void increment()
	{
		count++;
	}

	public synchronized void multipleIncrement(int times){
		//complete this code
	}
  
	public synchronized float getCount(){return count;}
}

