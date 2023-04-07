package employees;

import java.util.*;

public class GenerateEmployees<T extends Employees> {
    private Set<T> employeesDepartment = new TreeSet<>();
    private Iterator<T> iterator;


    public Set<T> getEmployeesDepartment() {
        return employeesDepartment;
    }

    public void addEmployee(T employee) {
        employeesDepartment.add(employee);
        System.out.println("We added new employee: " + employee.getName() + " " + employee.getSurname());
    }

    public void deleteEmployee(T employee) {
        if (searchEmployee(employee)) employeesDepartment.remove(employee);
        else System.out.println("Not found for delete.");
    }

    public boolean searchEmployee(T employee) {
        iterator = employeesDepartment.iterator();
        boolean flag = false;
        while (iterator.hasNext()) {

            T empl = iterator.next();
            if (employee.equals(empl)) return flag = true;
        }
        return flag;
    }

    public void print() {
        iterator = employeesDepartment.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public Set<T> printGetSortAge() {
        Set<T> set = new TreeSet<>(new AgeCoparatorEmployees());
        set.addAll(employeesDepartment);
        System.out.println("Отсортировка по возрасту : ");
        iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        return set;
    }
}
