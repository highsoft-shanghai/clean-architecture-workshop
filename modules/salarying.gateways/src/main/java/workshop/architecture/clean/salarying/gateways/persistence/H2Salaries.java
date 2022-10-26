package workshop.architecture.clean.salarying.gateways.persistence;

import org.springframework.stereotype.Component;
import workshop.architecture.clean.salarying.domain.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class H2Salaries implements Salaries {

    private @Resource SpringDataSalaryRepository repository;

    @Override
    public List<Salary> get(Integer year, Integer month) {
        return repository.getAllByYearAndMonth(year, month).stream().map(H2Salary::asDomain).collect(Collectors.toList());
    }

    @Override
    public void add(Salary salary) {
        repository.save(new H2Salary(salary));
    }

    @Override
    public void clear() {
        repository.deleteAll();
    }

}
