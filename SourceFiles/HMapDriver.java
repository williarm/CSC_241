package ch08.apps;
import java.util.Random;

import ch08.maps.*;

public class HMapDriver 
{
  public static void main(String[] args)
  {
    boolean result;
    HMap<Integer, String> test;
    final int SIZE = 10;
    final int IDRANGE = 10001;
    final int INITIALRANGE = 2;
    test = new HMap<Integer, String>(SIZE, 0.75);
    int randomID;
    String employeeInitials;
    final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	long t_in, t_out;
	Random myRandomID = new Random();
	Random randomIndex = new Random();
	String randomInitials = "";
	t_in = System.nanoTime();
	test.put(100, "IT");
	t_out = System.nanoTime();
	System.out.println("Total time for insertion of: " + 100 + ":" + "IT" + " is:" + (t_out-t_in));
	//test.remove(100);
	for(int i = 0; i < SIZE; i++){
		//compute randomID here:
		randomID = myRandomID.nextInt(IDRANGE);
		for(int j = 0; j < INITIALRANGE; j++)
			randomInitials += letters.charAt(randomIndex.nextInt(letters.length())); 
		t_in = System.nanoTime();
	    test.put(randomID, randomInitials);
	    t_out = System.nanoTime();
		System.out.println("Total time for insertion of: " + randomID + ":" + randomInitials + " is:" + (t_out-t_in));
		System.out.println(test);
		randomInitials = "";
	}
  }
}