package workshop.architecture.clean.personnel.application;

import workshop.architecture.clean.frameworks.application.core.UseCase;
import workshop.architecture.clean.personnel.domain.Employee;

@UseCase
public class AddEmployeeUseCase {

    private final Employee.Employees employees;

    public AddEmployeeUseCase(Employee.Employees employees) {
        this.employees = employees;
    }

    public void execute(EmployeeInput input) {
        input.asDomain().addIn(employees);
    }

}
