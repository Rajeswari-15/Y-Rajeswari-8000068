class RazorpayAdapter implements PaymentProcessor {
    Razorpay r = new Razorpay();

    public void pay(int amount) {
        r.makePayment(amount);
    }
}
