package employees;

public class CTO extends Manager{
    public CTO(String name, String surname, int age) {
        super(name, surname, age);
    }

    @Override
    String status() {
        return "Employee status: CTO";
    }
}
