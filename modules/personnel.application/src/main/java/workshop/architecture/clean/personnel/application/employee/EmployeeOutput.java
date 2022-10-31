package workshop.architecture.clean.personnel.application.employee;

import workshop.architecture.clean.personnel.domain.Employee;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeOutput {

    private final String id;
    private final String name;
    private final Instant birthday;
    private final Instant hireDate;
    private final List<ProjectOutput> projects;

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
