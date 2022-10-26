package workshop.architecture.clean.personnel.gateways.persistence;

import workshop.architecture.clean.frameworks.domain.core.archtype.Many;
import workshop.architecture.clean.personnel.domain.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "ps_employees")
public class H2Employee {

    private @Id @Column(name = "id") String id;
    private @Column(name = "name") String name;
    private @Column(name = "birthday") Instant birthday;
    private @Column(name = "hireDate") Instant hireDate;

    public H2Employee() {
    }

    public H2Employee(Employee employee) {
        this.id = employee.id();
        this.name = employee.name();
        this.birthday = employee.birthday();
        this.hireDate = employee.hireDate();
    }

    public String id() {
        return id;
    }

    public Employee asDomain(Many<Project> projects) {
        return Employee.restore(id, name, birthday, hireDate, projects);
    }

}
