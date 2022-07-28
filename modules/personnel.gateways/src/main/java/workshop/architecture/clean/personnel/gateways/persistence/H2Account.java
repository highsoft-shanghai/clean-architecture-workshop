package workshop.architecture.clean.personnel.gateways.persistence;

import workshop.architecture.clean.personnel.domain.Account;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class H2Account {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    public H2Account() {
    }

    public H2Account(Account account) {
        this.id = account.id();
        this.name = account.name();
    }

    public Account asDomain() {
        return new Account(id, name);
    }

}
