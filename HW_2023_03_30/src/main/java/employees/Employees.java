package employees;

import java.util.Objects;

abstract class Employees implements Comparable<Employees> {
    private String name;
    private String surname;
    private int age;

    public Employees(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    abstract String status();

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees = (Employees) o;
        return age == employees.age && Objects.equals(name, employees.name) && Objects.equals(surname, employees.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }

    @Override
    public String toString() {
        return "Employees{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Employees o) {
        return this.name.compareTo(o.getName());
    }
}
