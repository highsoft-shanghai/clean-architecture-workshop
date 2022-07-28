package workshop.architecture.clean.personnel.domain;

public class Account {
    private final String id;
    private final String name;

    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public interface Accounts {
        Account get(String id);
        void add(Account account);
        void clear();

    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

}
