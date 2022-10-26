package workshop.architecture.clean.salarying.domain;

import workshop.architecture.clean.frameworks.domain.core.GlobalId;
import workshop.architecture.clean.frameworks.domain.core.archtype.One;

public final class Salary {

    private final String id;
    private final One<Employee> employee;
    private final Integer year;
    private final Integer month;
    private final Double amount;

    public static Salary restore(String id, One<Employee> employee, Integer year, Integer month, Double amount) {
        return new Salary(id, employee, year, month, amount);
    }

    public static Salary create(One<Employee> employee, Integer year, Integer month, Double amount) {
        return new Salary(GlobalId.generate(), employee, year, month, amount);
    }

    private Salary(final String id, final One<Employee> employee, final Integer year, final Integer month, final Double amount) {
        this.id = id;
        this.employee = employee;
        this.year = year;
        this.month = month;
        this.amount = amount;
    }

    public String id() {
        return id;
    }

    public Employee employee() {
        return this.employee.get();
    }

    public String employeeId() {
        return employee.id();
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
