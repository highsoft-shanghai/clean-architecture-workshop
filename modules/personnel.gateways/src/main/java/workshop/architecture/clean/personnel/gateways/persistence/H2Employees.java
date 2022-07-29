package workshop.architecture.clean.personnel.gateways.persistence;

import org.springframework.data.repository.Repository;
import workshop.architecture.clean.personnel.domain.Employee;

public interface H2Employees extends Employee.Employees, Repository<H2Employee, String> {

    @Override
    default Employee get(String id) {
        return getById(id).asDomain();
    }

    H2Employee getById(String id);

    @Override
    default void add(Employee employee) {
        this.save(new H2Employee(employee));
    }

    void save(H2Employee employee);

    @Override
    default void clear() {
        this.deleteAll();
    }

    void deleteAll();

}
