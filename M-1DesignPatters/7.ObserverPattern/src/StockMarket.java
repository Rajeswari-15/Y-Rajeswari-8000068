import java.util.*;

class StockMarket {
    List<Observer> list = new ArrayList<>();

    void add(Observer o) {
        list.add(o);
    }

    void notifyAllObs(int price) {
        for (Observer o : list) o.update(price);
    }
}