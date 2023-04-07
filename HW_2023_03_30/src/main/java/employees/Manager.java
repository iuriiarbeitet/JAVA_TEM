package employees;

public class Manager extends Employees{

    public Manager(String name, String surname, int age) {
        super(name, surname, age);
    }

    @Override
    String status() {
        return "Employee status: manager.";
    }
}
