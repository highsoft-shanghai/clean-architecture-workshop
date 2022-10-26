package workshop.architecture.clean.personnel.application.project;

import workshop.architecture.clean.personnel.domain.Project;

public class ProjectOutput {

    private final String id;
    private final String name;
    private final String employeeId;
    private final String employeeName;

    public ProjectOutput(Project project) {
        this.id = project.id();
        this.name = project.name();
        this.employeeId = project.employee().id();
        this.employeeName = project.employee().name();
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
