public class Main {
    public static void main(String[] args) {
        Student s = new Student("Raji", 101);
        StudentView v = new StudentView();

        StudentController c = new StudentController(s, v);
        c.updateView();
    }
}