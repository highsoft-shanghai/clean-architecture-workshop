package workshop.architecture.clean.personnel.domain;

import workshop.architecture.clean.frameworks.domain.core.GlobalId;

import java.time.Instant;

public final class Employee {

    private final String id;
    private final String name;
    private final Instant birthday;
    private final Instant hireDate;

    public static Employee getById(final String id, Employees employees) {
        return employees.get(id);
    }

    public static Employee restore(String id, String name, Instant birthday, Instant hireDate) {
        return new Employee(id, name, birthday, hireDate);
    }

    public static Employee create(String name, Instant birthday, Instant hireDate) {
        return new Employee(GlobalId.generate(), name, birthday, hireDate);
    }

    public void addIn(Employees employees) {
        employees.add(this);
    }

    private Employee(String id, String name, Instant birthday, Instant hireDate) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.hireDate = hireDate;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Instant birthday() {
        return birthday;
    }

    public Instant hireDate() {
        return hireDate;
    }

    public interface Employees {
        void add(Employee employee);
        Employee get(String id);
        void clear();
    }

}
