package workshop.architecture.clean.salarying.gateways.persistence;

import org.springframework.data.repository.Repository;
import workshop.architecture.clean.salarying.domain.*;

public interface H2Salaries extends Salaries, Repository<H2Salary, String> {

    @Override
    default Salary get(String employeeId, Integer year, Integer month) {
        return getByEmployeeIdAndYearAndMonth(employeeId, year, month).asDomain();
    }

    H2Salary getByEmployeeIdAndYearAndMonth(String id, Integer year, Integer month);

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
