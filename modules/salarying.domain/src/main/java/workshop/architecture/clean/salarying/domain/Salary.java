package workshop.architecture.clean.salarying.domain;

import workshop.architecture.clean.frameworks.domain.core.GlobalId;

public final class Salary {

    private final String id;
    private final Salary.Employee employee;
    private final Integer year;
    private final Integer month;
    private final Double amount;

    public static Salary restore(String id, Salary.Employee employee, Integer year, Integer month, Double amount) {
        return new Salary(id, employee, year, month, amount);
    }

    public static Salary create(Salary.Employee employee, Integer year, Integer month, Double amount) {
        return new Salary(GlobalId.generate(), employee, year, month, amount);
    }

    private Salary(final String id, final Salary.Employee employee, final Integer year, final Integer month, final Double amount) {
        this.id = id;
        this.employee = employee;
        this.year = year;
        this.month = month;
        this.amount = amount;
    }

    public String id() {
        return id;
    }

    public workshop.architecture.clean.salarying.domain.Employee employee() {
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

    public interface Employee {

        String id();

        workshop.architecture.clean.salarying.domain.Employee get();

    }

}
