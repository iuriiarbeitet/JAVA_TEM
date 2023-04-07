package employees;

public class TeamLead extends Manager {

    public TeamLead(String name, String surname, int age) {
        super(name, surname, age);
    }

    @Override
    String status() {
        return "employee status: TeamLead";
    }
}
