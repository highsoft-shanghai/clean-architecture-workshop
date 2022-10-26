package workshop.architecture.clean.personnel.domain;

import workshop.architecture.clean.frameworks.domain.core.GlobalId;

import java.time.Instant;

public final class Employee {

    private final String id;
    private final String name;
    private final Instant birthday;
    private final Instant hireDate;

    public static Employee restore(String id, String name, Instant birthday, Instant hireDate) {
        return new Employee(id, name, birthday, hireDate);
    }

    public static Employee create(String name, Instant birthday, Instant hireDate) {
        return new Employee(GlobalId.generate(), name, birthday, hireDate);
    }

    private Employee(final String id, final String name, final Instant birthday, final Instant hireDate) {
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

}
