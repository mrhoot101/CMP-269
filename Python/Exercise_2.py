from abc import abstractmethod, ABC


class Payable(ABC):
    @abstractmethod
    def processPayment(self, amount):
        pass
    @abstractmethod
    def getPaymentStatus(self):
        pass
# End of class Payable

class PaymentMethod(Payable, ABC):
    totalTransactions  = 0

    def __init__(self, accountHolder, balance):
        self._accountHolder = accountHolder
        self._balance = balance

    @abstractmethod
    def validateAccount(self):
        pass
# End of class PaymentMethod

class CreditCard(PaymentMethod):
    def __init__(self, accountHolder, balance, creditLimit):
        super().__init__(accountHolder, balance)
        self.__creditLimit = creditLimit

    def processPayment(self, amount):
        if amount > (self._balance + self.__creditLimit):
            print("Transaction Declined")
        else:
            self._balance = self._balance - amount
            PaymentMethod.totalTransactions = PaymentMethod.totalTransactions + 1
            print("Successful transation")

    def getPaymentStatus(self):
        pass

    def validateAccount(self):
        pass
# End of class CreditCard

class MealPlan(PaymentMethod):
    def __init__(self, accountHolder, balance):
        super().__init__(accountHolder, balance)

    def validateAccount(self):
        if (self._balance < 0):
            print("Not enough funds")
            self._balance = 0
        else:
            print("Enough funds")

    def processPayment(self, amount):
        self._balance = self._balance - amount # Processing the payment

        if (self._balance < 0):     #Checking if ti was a valid transaction
            self.validateAccount()
            self._balance = self._balance + amount
            print("Transaction Declined")
        else:
            self.validateAccount()
            PaymentMethod.totalTransactions = PaymentMethod.totalTransactions + 1
            print("Successful transation")

    def getPaymentStatus(self):
        pass
# End of class MealPlan

if(__name__ == "__main__"):
    mealAcc = MealPlan("Moises", 100)
    creditAcc = CreditCard("Jenny Card", 100, 100)

    paymentQueue = (mealAcc, creditAcc)
    for payment in paymentQueue:
        payment.processPayment(50.0)

    print(f"\nTotal transaction(s): {PaymentMethod.totalTransactions}")