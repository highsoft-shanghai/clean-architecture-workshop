package workshop.architecture.clean.personnel.gateways.persistence;

import org.springframework.data.repository.Repository;
import workshop.architecture.clean.personnel.domain.Account;

public interface H2Accounts extends Account.Accounts, Repository<H2Account, String> {

    @Override
    default Account get(String id) {
        return getById(id).asDomain();
    }

    H2Account getById(String id);

    @Override
    default void add(Account account) {
        this.save(new H2Account(account));
    }

    void save(H2Account account);

    @Override
    default void clear() {
        this.deleteAll();
    }

    void deleteAll();

}
