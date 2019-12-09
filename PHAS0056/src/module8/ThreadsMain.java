package module8;

public class ThreadsMain extends Thread {

	public static void main(String[] args) throws InterruptedException {
		
		
		CountdownTask task1 = new CountdownTask(10000);
		PrimeNumberTask task2 = new PrimeNumberTask();
		
		Thread thread1 = new Thread(task1);
		Thread thread2 = new Thread(task2);
		
		thread1.start();
		thread2.start();
		
		thread1.join();
		thread2.interrupt();
		
		System.out.println(task2.getPrimes());
		System.out.println(task2.primes);
	}

}
