package workshop.architecture.clean.salarying.gateways.persistence;

import org.springframework.data.repository.Repository;
import workshop.architecture.clean.salarying.domain.*;

public interface H2Salaries extends Salaries, Repository<H2Salary, String> {

    @Override
    default Salary get(String id) {
        return getById(id).asDomain();
    }

    H2Salary getById(String id);

    @Override
    default void add(Salary salary) {
        this.save(new H2Salary(salary));
    }

    void save(H2Salary employee);

    @Override
    default void clear() {
        this.deleteAll();
    }

    void deleteAll();

}
