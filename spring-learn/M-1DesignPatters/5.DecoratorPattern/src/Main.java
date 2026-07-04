public class Main {
    public static void main(String[] args) {
        Notifier n = new SMSDecorator(new EmailNotifier());
        n.send();
    }
}