package workshop.architecture.clean.personnel.application;

import workshop.architecture.clean.personnel.domain.Employee;

import java.time.Instant;

public class EmployeeInput {

    private final String id;
    private final String name;
    private final Instant birthday;
    private final Instant hireDate;

    public EmployeeInput(String id, String name, Instant birthday, Instant hireDate) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.hireDate = hireDate;
    }

    public Employee asDomain() {
        return Employee.create(name, birthday, hireDate);
    }

}
