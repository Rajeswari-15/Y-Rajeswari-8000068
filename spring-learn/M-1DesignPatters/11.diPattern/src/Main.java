public class Main {
    public static void main(String[] args) {
        CustomerService s =
            new CustomerService(new CustomerRepositoryImpl());

        s.show();
    }
}