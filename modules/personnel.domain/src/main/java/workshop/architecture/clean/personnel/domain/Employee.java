package workshop.architecture.clean.personnel.domain;

import java.time.Instant;

public class Employee {

    private final String id;
    private final String name;
    private final Instant birthday;
    private final Instant hireDate;

    public static Employee restore(final String id, Employees employees) {
        return employees.get(id);
    }

    public Employee(String id, String name, Instant birthday, Instant hireDate) {
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
