package employees;

public class Senior extends TeamLead{
    public Senior(String name, String surname, int age) {
        super(name, surname, age);
    }

    @Override
    String status() {
        return "Employee status: Senior";
    }
}
