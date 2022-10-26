package workshop.architecture.clean.salarying.gateways.persistence;

import workshop.architecture.clean.personnel.domain.Employees;
import workshop.architecture.clean.salarying.domain.Salary;

import javax.persistence.*;

@Entity
@Table(name = "sl_salaries")
public class H2Salary {

    private @Id @Column(name = "id") String id;
    private @Column(name = "e_id") String employeeId;
    private @Column(name = "year") Integer year;
    private @Column(name = "month") Integer month;
    private @Column(name = "amount") Double amount;

    public H2Salary() {
    }

    public H2Salary(Salary salary) {
        this.id = salary.id();
        this.employeeId = salary.employeeId();
        this.year = salary.year();
        this.month = salary.month();
        this.amount = salary.amount();
    }

    public Salary asDomain(Employees employees) {
        return Salary.restore(id, new H2Salaries.SalaryEmployee(employeeId, employees), year, month, amount);
    }

}
