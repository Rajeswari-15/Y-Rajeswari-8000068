public class Main {
    public static void main(String[] args) {
        PaymentContext c = new PaymentContext();
        c.setStrategy(new CreditCard());
        c.pay(500);
    }
}