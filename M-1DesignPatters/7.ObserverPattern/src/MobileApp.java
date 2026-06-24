class MobileApp implements Observer {
    public void update(int price) {
        System.out.println("Mobile: " + price);
    }
}