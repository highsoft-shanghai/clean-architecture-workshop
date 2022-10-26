package workshop.architecture.clean.salarying.gateways.persistence;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface SpringDataSalaryRepository extends Repository<H2Salary, String> {

    List<H2Salary> getAllByYearAndMonth(Integer year, Integer month);

    void save(H2Salary employee);

    void deleteAll();

}
