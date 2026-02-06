package Exercise_1;

import java.util.ArrayList;

public class ChallengeLogic {

	public static void main(String[] args) {
		ArrayList<Payable> paymentQueue = new ArrayList<Payable>();
		paymentQueue.add(new CreditCard("", 4));
		paymentQueue.add(new MealPlan ("", 4));

	}

}
