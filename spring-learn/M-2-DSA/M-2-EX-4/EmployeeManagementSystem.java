class Employee {

    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int employeeId,
             String name,
             String position,
             double salary) {

        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}

public class EmployeeManagementSystem {

    static Employee[] employees = new Employee[100];
    static int count = 0;

    static void addEmployee(Employee e) {
        employees[count++] = e;
    }

    static void searchEmployee(int id) {

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId == id) {

                System.out.println("Found: "
                        + employees[i].name);
                return;
            }
        }

        System.out.println("Not Found");
    }

    static void traverseEmployees() {

        for (int i = 0; i < count; i++) {
            System.out.println(employees[i].employeeId
                    + " "
                    + employees[i].name);
        }
    }

    static void deleteEmployee(int id) {

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId == id) {

                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }

                count--;
                break;
            }
        }
    }

    public static void main(String[] args) {

        addEmployee(new Employee(1, "Raji", "Developer", 50000));
        addEmployee(new Employee(2, "Anu", "Tester", 40000));

        traverseEmployees();

        searchEmployee(1);

        deleteEmployee(2);

        System.out.println("\nAfter Delete");
        traverseEmployees();
    }
}
