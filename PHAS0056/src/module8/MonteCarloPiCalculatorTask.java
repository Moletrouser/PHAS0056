package module8;

import java.util.concurrent.Callable;
import java.util.Random;

public class MonteCarloPiCalculatorTask implements Callable<Double> {
	 private final long n_points;
	 
	 public MonteCarloPiCalculatorTask(long nPoints) {
		 this.n_points = nPoints; // nPoints sets the number of points to sample
	 }
	 
	 
	 @Override
	 public Double call() {
		 Random rand = new Random();
		 long n_in = 0;
		 for (long iPoint = 0; iPoint < n_points; ++iPoint) {
			 double x = rand.nextDouble(); // generates a random x value between 0 and 1
			 double y = rand.nextDouble(); // generates a random y value between 0 and 1
			 double r2 = x*x + y*y; // finds the length of the vector
			 if (r2 < 1.0) ++n_in; // checks if r is less than 1, adds the point to the list if so
		 }
		 return 4.0 * n_in / n_points; // returns the pi estimation
	 }	 
}