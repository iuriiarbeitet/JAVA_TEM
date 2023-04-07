package employees;

import java.util.Comparator;

public class AgeCoparatorEmployees implements Comparator <Employees> {
    @Override
    public int compare(Employees o1, Employees o2) {
        return o1.getAge() - o2.getAge();
    }
}
