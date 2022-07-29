package workshop.architecture.clean.salarying.application;

import workshop.architecture.clean.frameworks.application.core.UseCase;
import workshop.architecture.clean.frameworks.context.core.Context;
import workshop.architecture.clean.salarying.domain.*;

@UseCase
public class SearchSalaryByCurrentUserUseCase {

    private final Salary.Employees employees;
    private final Salaries salaries;

    public SearchSalaryByCurrentUserUseCase(Salary.Employees employees, Salaries salaries) {
        this.employees = employees;
        this.salaries = salaries;
    }

    public SalaryOutput execute(Integer year, Integer month) {
        Salary current = Salary.getBy(Context.currentUser().id(), year, month, salaries);
        return SalaryOutput.of(current, employees);
    }

}
