class SMSDecorator extends NotifierDecorator {
    SMSDecorator(Notifier n) {
        super(n);
    }

    public void send() {
        notifier.send();
        System.out.println("SMS sent");
    }
}