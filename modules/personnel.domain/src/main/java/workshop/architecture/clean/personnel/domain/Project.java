package workshop.architecture.clean.personnel.domain;

import workshop.architecture.clean.frameworks.domain.core.archtype.Aggregate;

public class Project implements Aggregate {

    private final String id;
    private final String employeeId;
    private final String name;

    public Project(String id, String employeeId, String name) {
        this.id = id;
        this.employeeId = employeeId;
        this.name = name;
    }

    @Override
    public String id() {
        return id;
    }

    public String employeeId() {
        return employeeId;
    }

    public String name() {
        return name;
    }

}
