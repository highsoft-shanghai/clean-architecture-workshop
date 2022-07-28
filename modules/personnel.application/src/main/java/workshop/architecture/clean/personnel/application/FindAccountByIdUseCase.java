package workshop.architecture.clean.personnel.application;

import workshop.architecture.clean.frameworks.application.core.UseCase;
import workshop.architecture.clean.personnel.domain.Account;

@UseCase
public class FindAccountByIdUseCase {

    private final Account.Accounts accounts;

    public FindAccountByIdUseCase(Account.Accounts accounts) {
        this.accounts = accounts;
    }

    public AccountOutput execute(String id) {
        return AccountOutput.by(accounts.get(id));
    }

}
