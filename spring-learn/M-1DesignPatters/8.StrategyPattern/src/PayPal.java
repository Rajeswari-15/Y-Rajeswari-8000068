class PayPal implements PaymentStrategy {
    public void pay(int amt) {
        System.out.println("Paid by PayPal: " + amt);
    }
}