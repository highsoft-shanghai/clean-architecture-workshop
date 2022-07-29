package workshop.architecture.clean.salarying.domain;

import java.util.List;
import java.util.stream.Stream;

public class SalaryList {

    private final List<Salary> salaries;

    public static SalaryList getBy(Integer year, Integer month, Salaries salaries) {
        return new SalaryList(salaries.get(year, month));
    }

    public SalaryList(List<Salary> salaries) {
        this.salaries = salaries;
    }

    public Stream<Salary> stream() {
        return salaries.stream();
    }

}
