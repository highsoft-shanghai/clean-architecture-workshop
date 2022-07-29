package workshop.architecture.clean.personnel.application;

import workshop.architecture.clean.frameworks.application.core.UseCase;
import workshop.architecture.clean.personnel.domain.Employee;

@UseCase
public class GetEmployeeByIdUseCase {
    private final Employee.Employees employees;

    public GetEmployeeByIdUseCase(Employee.Employees employees) {
        this.employees = employees;
    }

    public EmployeeOutput execute(final String id) {
        return EmployeeOutput.of(employees.get(id));
    }

}
