package workshop.architecture.clean.personnel.domain;

import java.util.*;

public interface Projects {

    List<Project> findByEmployee(String employeeId);

    void add(Project project);

    Optional<Project> findByIdAndEmployeeId(String id, String employeeId);

    void clear();

}
