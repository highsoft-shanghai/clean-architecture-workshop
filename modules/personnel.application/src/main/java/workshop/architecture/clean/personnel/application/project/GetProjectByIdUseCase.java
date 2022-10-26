package workshop.architecture.clean.personnel.application.project;

import workshop.architecture.clean.frameworks.application.core.UseCase;

@UseCase
public class GetProjectByIdUseCase {

    public ProjectOutput execute(String id) {
        return new ProjectOutput("1", "project1", "zhangsan", "张三");
    }

}
