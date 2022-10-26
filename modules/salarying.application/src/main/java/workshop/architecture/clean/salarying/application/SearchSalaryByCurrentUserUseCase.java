package workshop.architecture.clean.salarying.application;

import workshop.architecture.clean.frameworks.application.core.UseCase;
import workshop.architecture.clean.salarying.domain.*;

import java.util.List;

@UseCase
public class SearchSalaryByCurrentUserUseCase {

    private final Salaries salaries;

    public SearchSalaryByCurrentUserUseCase(Salaries salaries) {
        this.salaries = salaries;
    }

    public List<SalaryOutput> execute(Integer year, Integer month) {
        SalaryList current = SalaryList.getBy(year, month, salaries);
        return SalaryOutputs.of(current).get();
    }

}
