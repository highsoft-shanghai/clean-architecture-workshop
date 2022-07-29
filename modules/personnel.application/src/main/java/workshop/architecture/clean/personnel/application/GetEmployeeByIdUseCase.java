package workshop.architecture.clean.personnel.application;

import workshop.architecture.clean.frameworks.application.core.UseCase;
import workshop.architecture.clean.personnel.domain.*;

@UseCase
public class GetEmployeeByIdUseCase {

    private final Employees employees;

    public GetEmployeeByIdUseCase(Employees employees) {
        this.employees = employees;
    }

    public Employee execute(String id) {
        return Employee.getById(id, employees);
    }

}
