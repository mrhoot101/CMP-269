package Exercise_1;

import java.util.ArrayList;

public class ChallengeLogic {

	public static void main(String[] args) {
		ArrayList<Payable> paymentQueue = new ArrayList<Payable>();
		paymentQueue.add(new CreditCard("David", 100));
		paymentQueue.add(new MealPlan ("Mary", 500));
		
		for (Iterator iterator = paymentQueue.iterator(); iterator.hasNext();) {
			Payable payable = (Payable) iterator.next();
			payable.processPayment(50.0);
		}
		System.out.println(PaymentMethod.totalTransactions);
	}

}

