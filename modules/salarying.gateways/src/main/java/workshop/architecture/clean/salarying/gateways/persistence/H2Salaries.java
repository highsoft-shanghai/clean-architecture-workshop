package workshop.architecture.clean.salarying.gateways.persistence;

import org.springframework.data.repository.Repository;
import workshop.architecture.clean.salarying.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public interface H2Salaries extends Salaries, Repository<H2Salary, String> {

    @Override
    default List<Salary> get(Integer year, Integer month) {
        return getAllByYearAndMonth(year, month).stream().map(H2Salary::asDomain).collect(Collectors.toList());
    }

    List<H2Salary> getAllByYearAndMonth(Integer year, Integer month);

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
