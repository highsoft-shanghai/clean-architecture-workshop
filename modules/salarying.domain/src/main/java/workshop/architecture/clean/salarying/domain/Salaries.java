package workshop.architecture.clean.salarying.domain;

public interface Salaries {

    Salary get(String employeeId, Integer year, Integer month);

    void add(Salary salary);

    void clear();

}
