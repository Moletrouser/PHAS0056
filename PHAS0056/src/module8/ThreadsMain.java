package module8;

public class ThreadsMain extends Thread {

	public static void main(String[] args) throws InterruptedException {
		
		
		CountdownTask task1 = new CountdownTask(10000); // creates a new instance of the countdown task with a timer of 10 seconds
		PrimeNumberTask task2 = new PrimeNumberTask(); // creates a new instance of the prime number task
		
		Thread thread1 = new Thread(task1); // creates a separate thread for each task
		Thread thread2 = new Thread(task2);
		
		thread1.start(); // starts both threads
		thread2.start();
		
		thread1.join(); // joins thread 1 to the main thread 
		thread2.interrupt(); // interrupts the prime number task once the countdown is finished
		
		System.out.println("The total number of primes found was: " +task2.getPrimes());// prints the number of primes found
		System.out.println("The largest prime found was: " +task2.getLastPrime() +" Wow! That's a big prime!"); // prints the largest prime found
		System.out.println("The largest number checked was: " +task2.getLastChecked() +" Wow! I can't believe it's not prime!");

	}

}
