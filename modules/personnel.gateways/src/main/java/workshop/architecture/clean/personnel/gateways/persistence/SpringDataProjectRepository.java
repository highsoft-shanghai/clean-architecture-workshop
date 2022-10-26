package workshop.architecture.clean.personnel.gateways.persistence;

import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.stream.Stream;

public interface SpringDataProjectRepository extends Repository<H2Project, String> {

    Stream<H2Project> findByEmployeeId(String employeeId);

    void save(H2Project project);

    Optional<H2Project> findByEmployeeIdAndId(String employeeId, String id);

    void deleteAll();

    H2Project findById(String id);

}
