package module1;

import java.lang.Math;

public class AlgorithmControl {
	
	
	// defines the loop function that counts up from integer input imin
	// to integers input imax in steps of size 1
	public void loop(int imin, int imax) {
		int i = 0;
		for (i = imin; i <= imax; i=i+1) {
				System.out.println(i);
		}
		return; 
	}
	
	// defines the decrement function that counts down from integer input imax
	// to integer input imin in steps of size 1
	public void decrement(int imax, int imin) {
		while(imax >= imin) {
			System.out.println(imax);
			imax = imax - 1;
			}
		return;
	}
	
	// defines the increment function which counts from double input imin
	// to double input imin in steps of size 0.1
	public void increment(double imin, double imax) {
		double i = 0;
		for (i = imin; i<=imax; i = i + 0.1) {
			i = i*10;  // this code corrects for floating point errors due to the data type being double.
			i = Math.round(i);  // it makes sure that i is always an exact multiple of 0.1
			i = i/10;  
			System.out.println(i); }
		return;
			
	}
	
	// defines the timer function which loops for the inputted amound of time, maxTime, and 
	// prints to the screen how many loops its performed every loopStep number of loops
	public int timer(long maxTime, int loopSteps) {			
		long time = +System.currentTimeMillis();
		long targettime = time + maxTime;
		int i = 0;
	    while(System.currentTimeMillis() <= targettime) {
	    	i = i + 1;
	    	int remainder = i % loopSteps;
	    	if (remainder == 0) {
	    		System.out.println("This is loop number: " +i); 
	    		}
	    	else;
	    }
	 // when the outer loop terminates the code prints the total number of loops performed
	    System.out.println("The total number of loops was: " +i); 
	    return i;
	}
	    		



	
	
	public static void main(String[] args) {
		
		// defines a new object of the algorithm control class
		AlgorithmControl ac = new AlgorithmControl();
		
		// uses the loop function to count from 1 to 8
		System.out.println("Counting from 1 to 8:");
		ac.loop(1, 8);
		System.out.println("\n");	
		
		// uses the decrement function to count down from 10 to -5
		System.out.println("Counting down from 10 to -5: ");
		ac.decrement(10,-5);
		System.out.println("\n");	
		
		// uses the increment function to count from 2.5 to 4.3 in intervals of 0.1
		System.out.println("Counting from 2.5 to 4.3 in intervals of 0.1: ");
		ac.increment(2.5, 4.3);
		System.out.println("\n");
		
		// prints the current time in milliseconds since 1/1/1970
		System.out.println("The time is: " +System.currentTimeMillis());
		
		// calls the timer function to run for 10 seconds with loop number announcements every 1000 loops
	    ac.timer(10000, 1000);
	    System.out.println("\n");
	    
	    // calls the timer function to run for 10 seconds with loop number announcements every 50000 loops
	    ac.timer(10000,  50000);
	    System.out.println("\n");
	    
	    /* If you want to run the timer function twice with the two different loop steps and compare the final loop 
	     *  counts then simply comment out either of ac.timer calls to allow only one to run. Otherwise the console 
	     *  outputs runs out of space and won't allow you to scroll far enough back to see both final loop counts
	     *  or the previous increment/decrement function outputs etc
	     */
	    
	    System.out.println("On my computer, with a loopStep of 1000 the timer function completed 968390668 loops before terminating");
	    System.out.println("This is of the order 900 million loops");
	    System.out.println("On my computer, with a loopStep of 50000 the timer function completed 1755906630 loops before terminating");
	    System.out.println("This is of the order 1.7 billion loops, or roughly twice as many loops as the function completed with a loopStep of 1000");
	    System.out.println("I believe this is because, when the program has to print loop counts less frequently, less processor clock cycles are used up printing the loop count to the profile");
	    System.out.println("Because of this, with the 50000 loopStep the loop can execute more quickly and complete more loops in the same amount compared to to the 1000 loopStep ");
	}
		
}
 
	
//}