package employees;

public class Junior extends Middle {

    public Junior(String name, String surname, int age) {
        super(name, surname, age);
    }

    @Override
    String status() {
        return "Employee status: Junior";
    }
}
