package Exercise_5;

import java.util.Iterator;

public class BankAccount {
	private int balance = 1000;

	public static void main(String[] args) {

		// Exercise 3 start
		BankAccount b = new BankAccount();
		Thread husband = new Thread(() -> {
			for (int i = 0; i < 15; i++) {
				b.withdraw(100);
			}
		});
		Thread wife = new Thread(() -> {
			for (int i = 0; i < 15; i++) {
				b.withdraw(100);
			}
		});

		husband.start();
		wife.start();
		// Exercise 3 end

		// Exercise 4 start

		try {
		Thread heavyCalc = new Thread(() -> {
			int result = 0;
			for (int i = 1; i <= 1_000_000_000; i++) {
				result = i;
			}

			b.setResult(result);
		});

		heavyCalc.start();
			heavyCalc.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Calculation Finished: " + b.result);
	}

	public synchronized void withdraw(int amount) {
		if (balance >= amount) {
			balance = balance - amount;
			System.out.println(Thread.currentThread().getName() + ": " + balance);
		} else if (balance < 0) {
			System.err.println("Insufitient balance");
		}
	}

	private int result;

	public void setResult(int result) {
		this.result = result;
	}

}
