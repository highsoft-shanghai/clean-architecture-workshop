package workshop.architecture.clean.personnel.domain;

import workshop.architecture.clean.frameworks.domain.core.archtype.Aggregate;

public class Project implements Aggregate {

    private final String id;
    private final Project.Employee employee;
    private final String name;

    public Project(String id, Project.Employee employee, String name) {
        this.id = id;
        this.employee = employee;
        this.name = name;
    }

    @Override
    public String id() {
        return id;
    }

    public String employeeId() {
        return employee.id();
    }

    public String name() {
        return name;
    }

    public workshop.architecture.clean.personnel.domain.Employee employee() {
        return employee.get();
    }

    public interface Employee {

        String id();

        workshop.architecture.clean.personnel.domain.Employee get();

    }

}
