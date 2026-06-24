public class Main {
    public static void main(String[] args) {
        PaymentProcessor p = new RazorpayAdapter();
        p.pay(500);
    }
}
