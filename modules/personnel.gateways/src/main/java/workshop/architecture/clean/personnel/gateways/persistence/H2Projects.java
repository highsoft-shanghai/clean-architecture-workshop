package workshop.architecture.clean.personnel.gateways.persistence;

import org.springframework.stereotype.Component;
import workshop.architecture.clean.frameworks.domain.core.archtype.*;
import workshop.architecture.clean.personnel.domain.*;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class H2Projects implements Projects {

    private @Resource SpringDataProjectRepository repository;
    private @Resource Employees employees;

    @Override
    public List<Project> findByEmployee(String employeeId) {
        return repository.findByEmployeeId(employeeId).map(h2Project -> h2Project.asDomain(employees)).collect(Collectors.toList());
    }

    @Override
    public Project get(String id) {
        return repository.findById(id).asDomain(employees);
    }

    @Override
    public void add(Project project) {
        repository.save(new H2Project(project));
    }

    @Override
    public Optional<Project> findByIdAndEmployeeId(String id, String employeeId) {
        return repository.findByEmployeeIdAndId(employeeId, id).map(h2Project -> h2Project.asDomain(employees));
    }

    @Override
    public void clear() {
        repository.deleteAll();
    }

    static class ProjectEmployees extends NotHasOne<Employee> implements One<Employee> {

        public ProjectEmployees(String id, Aggregates<Employee> aggregates) {
            super(id, aggregates);
        }

    }

}
