package workshop.architecture.clean.personnel.gateways.persistence;

import org.springframework.stereotype.Component;
import workshop.architecture.clean.personnel.domain.*;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class H2Employees implements Employees {

    private @Resource SpringDataEmployeeRepository repository;
    private @Resource Projects projects;

    @Override
    public Employee get(String id) {
        return repository.getById(id).asDomain(new EmployeeProjects(id, projects));
    }

    @Override
    public Optional<Employee> getOptional(String id) {
        return Optional.ofNullable(repository.getById(id)).map(o -> o.asDomain(new EmployeeProjects(id, projects)));
    }

    @Override
    public void add(Employee employee) {
        repository.save(new H2Employee(employee));
    }

    @Override
    public void addAll(Collection<Employee> employees) {
        repository.save(employees.stream().map(H2Employee::new).collect(Collectors.toList()));
    }

    @Override
    public void remove(String id) {
        repository.removeById(id);
    }

    @Override
    public void remove(Collection<String> ids) {
        repository.removeByIdIn(ids);
    }

    @Override
    public List<Employee> list(Collection<String> ids) {
        return repository.getByIdIn(ids).parallel().map(o -> o.asDomain(new EmployeeProjects(o.id(), projects))).collect(Collectors.toList());
    }

    static class EmployeeProjects implements Employee.Projects {

        private final String employeeId;
        private final Projects projects;

        EmployeeProjects(String employeeId, Projects projects) {
            this.employeeId = employeeId;
            this.projects = projects;
        }

        @Override
        public List<Project> all() {
            return projects.findByEmployee(employeeId);
        }

    }

}
