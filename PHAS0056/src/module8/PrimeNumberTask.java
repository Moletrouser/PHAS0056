package module8;

import java.util.ArrayList;

public class PrimeNumberTask implements Runnable {
	
	ArrayList<Integer> primes = new ArrayList<Integer>();
	
	
	public boolean isPrime(int n) {
		//check if n is a multiple of 2
	    if (n%2==0) return false;
	    //if not, then check the odds
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	
	
	
	
	public void run() {
        	for(int i = 0; i <= Double.POSITIVE_INFINITY; ++i) {
        		if (Thread.currentThread().isInterrupted()) return;
        		if (isPrime(i)) {
        			primes.add(i);
        		}
        	}         	
	}
	
	
	public long getPrimes() {
		//System.out.println("The size of the primes array is: " +primes.size());
		return primes.size();
	}
	
	
	
	
	public static void main(String[] args) {
		

	}

}
