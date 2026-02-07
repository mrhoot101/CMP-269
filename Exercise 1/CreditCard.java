package Exercise_1;

public class CreditCard extends PaymentMethod{
	private double creditLimit;

	public CreditCard(String accountHolder, double balance) {
		super(accountHolder, balance);
	}
	@Override
	public void processPayment(double amount) {
		if (amount > (balance + creditLimit)) {
			System.out.println("Transaction Declined");
		}
		else {
			balance -= amount;
			totalTransactions++;
		}
		
	}
	
	@Override
	public String getPaymentStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void validateAccount() {
		// TODO Auto-generated method stub
		
	}
	
	
}
