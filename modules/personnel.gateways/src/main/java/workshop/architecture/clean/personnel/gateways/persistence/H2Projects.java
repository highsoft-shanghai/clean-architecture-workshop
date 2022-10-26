package workshop.architecture.clean.personnel.gateways.persistence;

import org.springframework.stereotype.Component;
import workshop.architecture.clean.personnel.domain.*;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class H2Projects implements Projects {

    private @Resource SpringDataProjectRepository repository;

    @Override
    public List<Project> findByEmployee(String employeeId) {
        return repository.findByEmployeeId(employeeId).map(H2Project::asDomain).collect(Collectors.toList());
    }

    @Override
    public void add(Project project) {
        repository.save(new H2Project(project));
    }

    @Override
    public Optional<Project> findByIdAndEmployeeId(String id, String employeeId) {
        return repository.findByEmployeeIdAndId(employeeId, id).map(H2Project::asDomain);
    }

    @Override
    public void clear() {
        repository.deleteAll();
    }

}
