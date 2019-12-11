package module8;

public class CountdownTask implements Runnable{
	
	long currentTime = System.currentTimeMillis();
	long maxTime;
	int x;
	
	
	public CountdownTask(int x) { // takes one input x, which is the milliseconds the timer should run for
		maxTime = x;
	}

    public void run() {
    	double elapsedTime = 0; // initialises the elapsed time as zero
    	long startTime = System.currentTimeMillis(); // logs what time the program starts
    	long endTime = currentTime + maxTime; // calculates when the timer should stop
    	while (currentTime < endTime) { // loops while there is still time left on the timer
    		currentTime = System.currentTimeMillis();
    		elapsedTime = (currentTime - startTime) / 1000.0; // calculates the time the program has been running for
    		System.out.println("Time elapsed is: " + Math.round(elapsedTime) +" seconds"); // prints the elapsed time
    		try {
    			Thread.sleep(1000); // tells the program to wait 1 second before printing again
    		}
    		catch (InterruptedException e) {
    			System.out.println("Thread has been interrupted");	
    		}
    		// the lines below were a previous attempt at printing the current time
    		//if ((elapsedTime%1 == 0))
    			//System.out.println("Time elapsed is: " + elapsedTime +" seconds");
    	}
    	return;
    }
    
}
