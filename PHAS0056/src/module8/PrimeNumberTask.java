package module8;

import java.util.ArrayList;

public class PrimeNumberTask implements Runnable {
	
	ArrayList<Integer> primes = new ArrayList<Integer>(); // initialises the primes array list
		
	public boolean isPrime(int n) {
		//check if n is a multiple of 2
	    if (n%2==0) return false;
	    //if not, then check the odds
	    // only checks for factors of n up to root n 
	    for(int i=3;i*i<=n;i+=2) { //since there can be no factors of size greater than root n
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	
	
	
	
	public void run() {
        	for(int i = 0; i <= Double.POSITIVE_INFINITY; ++i) {
        		if (Thread.currentThread().isInterrupted()) return;
        		if (isPrime(i)) { // checks if a number is prime
        			primes.add(i); // if it is prime, it is added to an array list 
        		}
        	}         	
	}
	
	
	public long getPrimes() { // a simple method to return the size of the primes array to check its 
		return primes.size(); // working correctly and the array list is being populated
	}
	
}
