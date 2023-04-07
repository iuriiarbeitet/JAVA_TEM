package employees;

public class Middle extends Senior {

    public Middle(String name, String surname, int age) {
        super(name, surname, age);
    }

    @Override
    String status() {
        return "Employee status: Middle";
    }
}
