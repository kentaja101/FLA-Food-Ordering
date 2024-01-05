package payment;

public class PaymentContext {
    private Payment payment;

    public PaymentContext(Payment payment) {
        this.payment = payment;
    }

    public void performPayment(double amount) {
        payment.pay(amount);
    }
}
