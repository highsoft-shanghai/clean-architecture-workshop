package workshop.architecture.clean.salarying.application;

import workshop.architecture.clean.salarying.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class SalaryOutputs {

    private final List<SalaryOutput> outputs;

    public static SalaryOutputs of(SalaryList salaries, Salary.Employees employees) {
        return new SalaryOutputs(salaries.stream().map(o -> SalaryOutput.of(o, employees)).collect(Collectors.toList()));
    }

    public SalaryOutputs(final List<SalaryOutput> outputs) {
        this.outputs = outputs;
    }

    public List<SalaryOutput> get() {
        return outputs;
    }

}
