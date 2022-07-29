package workshop.architecture.clean.personnel.application;

import workshop.architecture.clean.frameworks.application.core.UseCase;
import workshop.architecture.clean.personnel.domain.*;

@UseCase
public class AddEmployeeUseCase {

    private final Employees employees;

    public AddEmployeeUseCase(Employees employees) {
        this.employees = employees;
    }

    public void execute(EmployeeInput input) {
        input.asDomain().addIn(employees);
    }

}
