class CreditCard implements PaymentStrategy {
    public void pay(int amt) {
        System.out.println("Paid by Card: " + amt);
    }
}