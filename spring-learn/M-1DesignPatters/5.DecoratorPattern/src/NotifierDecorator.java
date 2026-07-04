abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    NotifierDecorator(Notifier n) {
        this.notifier = n;
    }
}
