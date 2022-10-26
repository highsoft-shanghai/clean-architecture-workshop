package workshop.architecture.clean.personnel.application;

import workshop.architecture.clean.personnel.domain.Project;

public class ProjectOutput {

    private final String id;
    private final String name;

    public static ProjectOutput of(Project project) {
        return new ProjectOutput(project);
    }

    public ProjectOutput(Project project) {
        this.id = project.id();
        this.name = project.name();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
