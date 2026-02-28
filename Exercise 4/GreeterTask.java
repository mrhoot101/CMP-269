package Exercise_5;

public class GreeterTask implements Runnable{

	public static void main(String[] args) {
		GreeterTask g = new GreeterTask();
		Thread thread1 = new Thread(g, "Lehman-Thread-1");
		Thread thread2 = new Thread(g, "Lehman-Thread-2");
		
		Thread thread3 = new Thread("Thread That sleeps for two seconds");
		System.out.println("Third thread " + thread3.getState());
		try {
			thread3.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		thread1.start();
		thread2.start();
		thread3.start();
		System.out.println("Third thread " + thread3.getState());
		
		try {
			Thread.sleep(500);
			System.out.println("Third thread " + thread3.getState());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println("Hello from " + Thread.currentThread().getName());
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.getMessage();			}
		}
	}

}
