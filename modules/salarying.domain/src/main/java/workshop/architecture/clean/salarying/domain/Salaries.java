package workshop.architecture.clean.salarying.domain;

import java.util.List;

public interface Salaries {

    List<Salary> get(Integer year, Integer month);

    void add(Salary salary);

    void clear();

}
