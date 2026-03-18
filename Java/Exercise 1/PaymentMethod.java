package Exercise_1;

public abstract class PaymentMethod implements Payable{
	static int totalTransactions = 0;
	protected String accountHolder;
	protected double balance;
	
	public PaymentMethod(String accountHolder, double balance) {
		this.accountHolder = accountHolder;
		this.balance = balance;
	}
	
	abstract void validateAccount();
}
