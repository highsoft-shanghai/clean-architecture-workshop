package workshop.architecture.clean.salarying.domain;

import workshop.architecture.clean.frameworks.domain.core.GlobalId;

public final class Salary {

    private final String id;
    private final String employeeId;
    private final Integer year;
    private final Integer month;
    private final Double amount;

    public static Salary restore(String id, String employeeId, Integer year, Integer month, Double amount) {
        return new Salary(id, employeeId, year, month, amount);
    }

    public static Salary create(String employeeId, Integer year, Integer month, Double amount) {
        return new Salary(GlobalId.generate(), employeeId, year, month, amount);
    }

    public static Salary getBy(String employeeId, Integer year, Integer month, Salaries salaries) {
        return salaries.get(employeeId, year, month);
    }

    private Salary(final String id, final String employeeId, final Integer year, final Integer month, final Double amount) {
        this.id = id;
        this.employeeId = employeeId;
        this.year = year;
        this.month = month;
        this.amount = amount;
    }

    public String id() {
        return id;
    }

    public String employeeName(Employees employees) {
        return employees.employeeName(this.employeeId);
    }

    public interface Employees {

        String employeeName(String id);

    }

    public String employeeId() {
        return employeeId;
    }

    public Integer year() {
        return year;
    }

    public Integer month() {
        return month;
    }

    public Double amount() {
        return amount;
    }

}
