package workshop.architecture.clean.salarying.application;

import workshop.architecture.clean.salarying.domain.Salary;

public final class SalaryOutput {

    private final String id;
    private final String employeeName;
    private final Integer year;
    private final Integer month;
    private final Double amount;

    public static SalaryOutput of(Salary salary, Salary.Employees employees) {
        return new SalaryOutput(salary, employees);
    }

    private SalaryOutput(Salary salary, Salary.Employees employees) {
        this.id = salary.id();
        this.employeeName = salary.employeeName(employees);
        this.year = salary.year();
        this.month = salary.month();
        this.amount = salary.amount();
    }

    public String getId() {
        return id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getMonth() {
        return month;
    }

    public Double getAmount() {
        return amount;
    }

}
