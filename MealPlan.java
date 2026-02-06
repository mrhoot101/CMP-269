package Exercise_1;

public class MealPlan extends PaymentMethod{

	public MealPlan(String accountHolder, double balance) {
		super(accountHolder, balance);
	}

	@Override
	public void processPayment(double amount) {
		if ((amount > balance)) {
			System.out.println("Transaction Declined");
			validateAccount();
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
		if (balance < 0) {
			System.out.println("Invalid Account");
			balance = 0;
		}else {
			System.out.println("Valid Account");
		}
		
	}

}
