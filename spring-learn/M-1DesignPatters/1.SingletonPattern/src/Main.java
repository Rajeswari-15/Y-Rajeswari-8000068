public class Main {
    public static void main(String[] args) {

        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();

        l1.log("Singleton Pattern Working!");

        System.out.println(l1 == l2); // true
    }
}