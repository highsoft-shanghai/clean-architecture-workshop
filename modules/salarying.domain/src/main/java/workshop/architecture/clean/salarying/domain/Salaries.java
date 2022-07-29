package workshop.architecture.clean.salarying.domain;

public interface Salaries {

    Salary get(String id);

    void add(Salary salary);

    void clear();

}
