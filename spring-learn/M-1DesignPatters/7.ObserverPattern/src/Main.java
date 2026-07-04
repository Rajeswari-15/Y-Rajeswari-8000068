public class Main {
    public static void main(String[] args) {
        StockMarket s = new StockMarket();

        s.add(new MobileApp());
        s.notifyAllObs(100);
    }
}