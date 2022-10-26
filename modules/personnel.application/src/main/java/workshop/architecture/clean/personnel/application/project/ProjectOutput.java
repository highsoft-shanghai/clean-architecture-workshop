package workshop.architecture.clean.personnel.application.project;

public class ProjectOutput {
    private final String id;
    private final String name;
    private final String employeeId;
    private final String employeeName;

    public ProjectOutput(String id, String name, String employeeId, String employeeName) {
        this.id = id;
        this.name = name;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

}
