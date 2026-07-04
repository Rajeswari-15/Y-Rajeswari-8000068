class CustomerService {
    CustomerRepository repo;

    CustomerService(CustomerRepository r) {
        this.repo = r;
    }

    void show() {
        System.out.println(repo.findCustomer());
    }
}