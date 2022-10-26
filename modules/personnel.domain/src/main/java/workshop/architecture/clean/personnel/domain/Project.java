package workshop.architecture.clean.personnel.domain;

import workshop.architecture.clean.frameworks.domain.core.archtype.*;

public class Project implements Aggregate {

    private final String id;
    private final One<Employee> employee;
    private final String name;

    public Project(String id, One<Employee> employee, String name) {
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

    public Employee employee() {
        return employee.get();
    }

}
