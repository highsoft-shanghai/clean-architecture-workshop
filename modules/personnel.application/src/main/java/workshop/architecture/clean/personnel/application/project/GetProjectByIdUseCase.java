package workshop.architecture.clean.personnel.application.project;

import workshop.architecture.clean.frameworks.application.core.UseCase;
import workshop.architecture.clean.personnel.domain.*;

import javax.annotation.Resource;

@UseCase
public class GetProjectByIdUseCase {

    private @Resource Projects projects;

    public ProjectOutput execute(String id) {
        Project project = projects.get(id);
        return new ProjectOutput(project);
    }

}
