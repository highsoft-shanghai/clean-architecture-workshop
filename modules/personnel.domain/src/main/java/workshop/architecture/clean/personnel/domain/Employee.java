package workshop.architecture.clean.personnel.domain;

import workshop.architecture.clean.frameworks.domain.core.GlobalId;
import workshop.architecture.clean.frameworks.domain.core.archtype.*;

import java.time.Instant;
import java.util.*;

public final class Employee implements Aggregate {

    private final String id;
    private final String name;
    private final Instant birthday;
    private final Instant hireDate;
    private final Many<Project> projects;

    public static Employee restore(String id, String name, Instant birthday, Instant hireDate, Many<Project> projects) {
        return new Employee(id, name, birthday, hireDate, projects);
    }

    public static Employee create(String name, Instant birthday, Instant hireDate) {
        return new Employee(GlobalId.generate(), name, birthday, hireDate, null);
    }

    private Employee(final String id, final String name, final Instant birthday, final Instant hireDate, Many<Project> projects) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.hireDate = hireDate;
        this.projects = projects;
    }

    @Override
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

    public Collection<Project> projects() {
        return projects.getAll();
    }

}
