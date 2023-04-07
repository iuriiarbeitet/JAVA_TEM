package employees;


public class Main {
    public static void main(String[] args) {

        GenerateEmployees<Employees> generateEmployees = new GenerateEmployees<>();

        generateEmployees.addEmployee(new TeamLead("Jhon", "Barton", 35));
        generateEmployees.addEmployee(new CTO("Carl", "Matew", 42));
        generateEmployees.addEmployee(new Junior("Iurii", "Rotari", 35));
        generateEmployees.addEmployee(new Junior("Vladislav", "Schwetz", 26));
        generateEmployees.addEmployee(new Manager("Michael", "Butiko", 45));
        generateEmployees.addEmployee(new Middle("Ivan", "Boiko", 30));
        generateEmployees.addEmployee(new Middle("Peter", "Schmidt", 32));
        System.out.println();
        generateEmployees.print();
        System.out.println();
        System.out.println(generateEmployees.searchEmployee(new TeamLead("Jhon", "Barton", 35)));
        System.out.println();
        generateEmployees.deleteEmployee(new TeamLead("Jhon", "Barton", 35));
        generateEmployees.print();

        System.out.println();
        generateEmployees.printGetSortAge();

    }
}
