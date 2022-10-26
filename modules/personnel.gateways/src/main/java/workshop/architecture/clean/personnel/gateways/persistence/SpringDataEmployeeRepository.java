package workshop.architecture.clean.personnel.gateways.persistence;

import org.springframework.data.repository.Repository;

import java.util.Collection;
import java.util.stream.Stream;

public interface SpringDataEmployeeRepository extends Repository<H2Employee, String> {

    H2Employee getById(String id);

    void save(H2Employee employee);

    void save(Collection<H2Employee> employees);

    Stream<H2Employee> getByIdIn(Collection<String> ids);

    void removeById(String id);

    void removeByIdIn(Collection<String> ids);

}
