package workshop.architecture.clean.personnel.gateways.ohs;

import org.springframework.web.bind.annotation.*;
import workshop.architecture.clean.personnel.application.project.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/projects")
public class ProjectsApi {

    private @Resource GetProjectByIdUseCase getProjectByIdUseCase;

    @GetMapping("/{id}")
    public ProjectOutput get(@PathVariable String id) {
        return getProjectByIdUseCase.execute(id);
    }

}
