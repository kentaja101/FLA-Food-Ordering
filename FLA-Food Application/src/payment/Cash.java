package payment;

public class Cash implements Payment{

	@Override
	public void pay(double amount) {
		System.out.println("Paid with Cash: $" + amount);
	}

}
