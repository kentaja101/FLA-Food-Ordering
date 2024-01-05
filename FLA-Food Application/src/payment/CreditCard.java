package payment;

public class CreditCard implements Payment{

	@Override
	public void pay(double amount) {
		System.out.println("Paid with Credit Card: $" + amount);
	}
	
}
