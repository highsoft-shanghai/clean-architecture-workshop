package workshop.architecture.clean.personnel.application;

import workshop.architecture.clean.frameworks.application.core.UseCase;
import workshop.architecture.clean.frameworks.context.core.Context;
import workshop.architecture.clean.personnel.domain.Employee;

@UseCase
public class GetEmployeeByCurrentUserUseCase {

    private final Employee.Employees employees;

    public GetEmployeeByCurrentUserUseCase(Employee.Employees employees) {
        this.employees = employees;
    }

    public EmployeeOutput execute() {
        return EmployeeOutput.of(Employee.getById(Context.currentUser().id(), employees));
    }

}
