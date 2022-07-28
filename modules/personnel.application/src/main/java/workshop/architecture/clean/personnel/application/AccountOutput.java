package workshop.architecture.clean.personnel.application;

import workshop.architecture.clean.personnel.domain.Account;

public final class AccountOutput {

    private final String id;
    private final String name;

    public static AccountOutput by(Account account) {
        return new AccountOutput(account.id(), account.name());
    }

    private AccountOutput(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
