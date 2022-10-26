package workshop.architecture.clean.salarying.domain;

import workshop.architecture.clean.frameworks.domain.core.archtype.Aggregate;

public class Employee implements Aggregate {

    private final String id;
    private final String name;

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

}
