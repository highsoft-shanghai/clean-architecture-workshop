package workshop.architecture.clean.personnel.application.employee;

import workshop.architecture.clean.frameworks.application.core.UseCase;
import workshop.architecture.clean.personnel.domain.*;

@UseCase
public class GetEmployeeByIdUseCase {

    private final Employees employees;

    public GetEmployeeByIdUseCase(Employees employees) {
        this.employees = employees;
    }

    public EmployeeOutput execute(String id) {
        Employee employee = employees.get(id);
        return new EmployeeOutput(employee);
    }

}
