package workshop.architecture.clean.personnel.gateways.persistence;

import org.springframework.stereotype.Component;
import workshop.architecture.clean.frameworks.domain.core.archtype.Many;
import workshop.architecture.clean.personnel.domain.*;

import javax.annotation.Resource;
import java.util.*;

@Component
public class H2Employees implements Employees {

    private @Resource SpringDataEmployeeRepository repository;
    private @Resource Projects projects;

    @Override
    public Employee get(String id) {
        return repository.getById(id).asDomain(new EmployeeProjects(id, projects));
    }

    @Override
    public void add(Employee employee) {
        repository.save(new H2Employee(employee));
    }

    static class EmployeeProjects implements Many<Project> {

        private final String employeeId;
        private final Projects projects;

        EmployeeProjects(String employeeId, Projects projects) {
            this.employeeId = employeeId;
            this.projects = projects;
        }

        @Override
        public Optional<Project> findOne(String id) {
            return projects.findByIdAndEmployeeId(id, employeeId);
        }

        @Override
        public List<Project> getAll() {
            return projects.findByEmployee(employeeId);
        }

    }

}
