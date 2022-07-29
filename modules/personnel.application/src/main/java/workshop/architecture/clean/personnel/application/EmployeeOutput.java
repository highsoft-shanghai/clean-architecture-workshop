package workshop.architecture.clean.personnel.application;

import workshop.architecture.clean.personnel.domain.Employee;

import java.time.Instant;

public class EmployeeOutput {

    private final String id;
    private final String name;
    private final Instant birthday;
    private final Instant hireDate;

    public static EmployeeOutput of(Employee employee) {
        return new EmployeeOutput(employee);
    }

    public EmployeeOutput(Employee employee) {
        this.id = employee.id();
        this.name = employee.name();
        this.birthday = employee.birthday();
        this.hireDate = employee.hireDate();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Instant getBirthday() {
        return birthday;
    }

    public Instant getHireDate() {
        return hireDate;
    }

}
