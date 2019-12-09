package module8;

public class CountdownTask implements Runnable{
	
	long currentTime = System.currentTimeMillis();
	private long previousTime;
	long maxTime;
	int x;
	
	public CountdownTask(int x) {
		previousTime = System.currentTimeMillis();
		maxTime = x;
		//System.out.println(maxTime);
	}

    public void run() {
    	double elapsedTime = 1;
    	long currentTime = System.currentTimeMillis();
    	long endTime = currentTime + maxTime;
    	//System.out.println(maxTime);
    	//System.out.println(currentTime + " -> " + endTime + " : " + (endTime - currentTime));
    	while (currentTime < endTime) {
    		currentTime = System.currentTimeMillis();
    		elapsedTime = (currentTime - previousTime) / 1000.0;
    		previousTime = currentTime;
    		//System.out.println("Current time in seconds is: " + elapsedTime);
    	}
    	//System.out.println("Time running in seconds was: " + elapsedTime*1000);
    	return;
    }
    
	

	public static void main(String[] args) {
		
		//System.out.println("The current time is:" +System.currentTimeMillis());
		

	}
	
}
