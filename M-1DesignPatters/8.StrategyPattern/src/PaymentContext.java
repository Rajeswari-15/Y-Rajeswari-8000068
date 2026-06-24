class PaymentContext {
    PaymentStrategy strategy;

    void setStrategy(PaymentStrategy s) {
        this.strategy = s;
    }

    void pay(int amt) {
        strategy.pay(amt);
    }
}