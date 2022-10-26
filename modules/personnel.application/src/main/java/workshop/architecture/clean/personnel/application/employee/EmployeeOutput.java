package workshop.architecture.clean.personnel.application.employee;

import workshop.architecture.clean.personnel.domain.Employee;

import java.time.Instant;
import java.util.Collection;
import java.util.stream.Collectors;

public class EmployeeOutput {

    private final String id;
    private final String name;
    private final Instant birthday;
    private final Instant hireDate;
    private final Collection<ProjectOutput> projects;

    public static EmployeeOutput of(Employee employee) {
        return new EmployeeOutput(employee);
    }

    public EmployeeOutput(Employee employee) {
        this.id = employee.id();
        this.name = employee.name();
        this.birthday = employee.birthday();
        this.hireDate = employee.hireDate();
        this.projects = employee.projects().stream().map(ProjectOutput::of).collect(Collectors.toList());
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

    public Collection<ProjectOutput> getProjects() {
        return projects;
    }

}
