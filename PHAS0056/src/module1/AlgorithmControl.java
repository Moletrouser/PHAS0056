package module1;

import java.lang.Math;

public class AlgorithmControl {
	
	long timenow = +System.currentTimeMillis();
	
	public void loop(int imin, int imax) {
		int i = 0;
			for (i = imin; i <= imax; i=i+1) {
				System.out.println(i); }
		return; 
	}
	
	public void decrement(int imax, int imin) {
		while(imax >= imin) {
			System.out.println(imax);
			imax = imax - 1;
			}
		return;
	}
		
	public void increment(double imin, double imax) {
		double i = 0;
		for (i = imin; i<=imax; i = i + 0.1) {
			i = i*10;
			i = Math.round(i);
			i = i/10;
			System.out.println(i); }
		return;
			
	}

	public void timer() {
		long targettime = timenow + 5000;
		int i = 0;
	    while(timenow <= targettime) {
	    	i = i + 1;
	    	int remainder = i % 100;
	    	if (remainder == 0) {
	    		System.out.println("This is loop number: " +i);}
	    return;
	    }
	    		
    }
	    			



	
	
	public static void main(String[] args) {

		AlgorithmControl ac = new AlgorithmControl();
		
		System.out.println("Counting from 1 to 8:");
		ac.loop(1, 8);
		System.out.println("\n");	
		
		System.out.println("Counting down from 10 to -5: ");
		ac.decrement(10,-5);
		System.out.println("\n");	
		
		System.out.println("Counting from 2.5 to 4.3 in intervals of 0.1: ");
		ac.increment(2.5, 4.3);
	
		System.out.println("The time is: " +System.currentTimeMillis());
	    ac.timer();
	}
		
}
 
	
//}