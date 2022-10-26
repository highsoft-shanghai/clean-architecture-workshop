package workshop.architecture.clean.salarying.gateways.persistence;

import org.springframework.stereotype.Component;
import workshop.architecture.clean.frameworks.domain.core.archtype.One;
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

    static class SalaryEmployee implements One<Employee> {

        private String employeeId;
        private final Employees employees;

        public SalaryEmployee(String employeeId, Employees employees) {
            this.employeeId = employeeId;
            this.employees = employees;
        }

        @Override
        public Employee get() {
            return convertEmployee(employees.get(employeeId));
        }

        @Override
        public String id() {
            return employeeId;
        }

        @Override
        public void add(Employee aggregate) {
        }

        @Override
        public void callOff() {
            this.employeeId = null;
        }

        private Employee convertEmployee(workshop.architecture.clean.personnel.domain.Employee employee) {
            return new Employee(employee.id(), employee.name());
        }

    }

}
