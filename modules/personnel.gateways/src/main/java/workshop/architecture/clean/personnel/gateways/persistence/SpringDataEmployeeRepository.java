package workshop.architecture.clean.personnel.gateways.persistence;

import org.springframework.data.repository.Repository;

public interface SpringDataEmployeeRepository extends Repository<H2Employee, String> {

    H2Employee getById(String id);

    void save(H2Employee employee);

}
