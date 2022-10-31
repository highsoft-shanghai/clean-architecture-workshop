package workshop.architecture.clean.salarying.gateways.persistence;

import org.springframework.stereotype.Component;
import workshop.architecture.clean.personnel.domain.Employees;
import workshop.architecture.clean.salarying.domain.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class H2Salaries implements Salaries {

    private @Resource SpringDataSalaryRepository repository;
    private @Resource Employees employees;

    @Override
    public List<Salary> get(Integer year, Integer month) {
        return repository.getAllByYearAndMonth(year, month).stream().map(h2Salary -> h2Salary.asDomain(employees)).collect(Collectors.toList());
    }

    @Override
    public void add(Salary salary) {
        repository.save(new H2Salary(salary));
    }

    @Override
    public void clear() {
        repository.deleteAll();
    }

    static class SalaryEmployee implements Salary.Employee {

        private final String employeeId;
        private final Employees employees;

        public SalaryEmployee(String employeeId, Employees employees) {
            this.employeeId = employeeId;
            this.employees = employees;
        }

        @Override
        public Employee get() {
            workshop.architecture.clean.personnel.domain.Employee employee = employees.get(employeeId);
            return new Employee(employee.id(), employee.name());
        }

        @Override
        public String id() {
            return employeeId;
        }

    }

}
