package module8;

import java.util.concurrent.*;
import java.util.*;

public class ThreadsTimer extends Thread {

	public static void main(String[] args) throws Exception {
		
			
		 long startTime1 = System.currentTimeMillis();  // notes the starting time of the calculation
		 long nPoints = 10000000L; // defines the number of points to be sampled
		 MonteCarloPiCalculatorTask task1 = new MonteCarloPiCalculatorTask(nPoints); // creates a new instance of the monte carlo method class
		 double pi1 = task1.call(); 
		 System.out.println("Pi estimation (using 1 thread) is :" +pi1); // prints the pi approximation
		 long timeTaken1 = (System.currentTimeMillis()-startTime1);
		 System.out.println("The time taken was: " +timeTaken1 +" milliseconds"); // prints the time taken
	
	
		 int nThreads2 = 4; // sets the number of threads to be used
		 ExecutorService threadPool2 = Executors.newFixedThreadPool(nThreads2); // creates a thread pool represented by an executable service object
		 List<Future<Double>> futures2 = new ArrayList<Future<Double>>();
		 for (int iThread = 0; iThread < nThreads2; ++iThread) {
		 	MonteCarloPiCalculatorTask task2 = new MonteCarloPiCalculatorTask(nPoints/nThreads2); // creates a new instance of the monte carlo method class
		 	Future<Double> future2 = threadPool2.submit(task2);
		 	futures2.add(future2);
		 }
		 double sum2 = 0.0;
		 long startTime2 = System.currentTimeMillis(); // notes the starting time of the calculation
		 for (int iThread = 0; iThread < nThreads2; ++iThread) {
			 double result2 = futures2.get(iThread).get();
			 sum2 += result2;
		 }
		 threadPool2.shutdown();
		 double pi2 = sum2/nThreads2;
		 System.out.println("Pi estimation (using 4 threads) is: " +pi2);  // prints the pi approximation
		 long timeTaken2 = (System.currentTimeMillis()-startTime2);
		 System.out.println("The time taken was: " +timeTaken2 +" milliseconds");  // prints the time taken
		 
		 System.out.println("\n");
		 System.out.println("Using 4 threads instead of 1 found results of the same level of accuracy");  
		 System.out.println("However being a Monte Carlo method, the results will differ with each run of the program");  
		 System.out.println("The most significant difference was in the time taken the find the results");
		 System.out.println("With 4 threads finding the results in a little less than a third of the time of 1 thread");
	}

}
