class StudentController {
    Student model;
    StudentView view;

    StudentController(Student m, Student v) {
        model = m;
        view = v;
    }

    void updateView() {
        view.show(model);
    }
}