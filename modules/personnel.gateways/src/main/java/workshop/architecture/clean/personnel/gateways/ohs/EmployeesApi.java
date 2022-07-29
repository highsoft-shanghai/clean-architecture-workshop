package workshop.architecture.clean.personnel.gateways.ohs;

import org.springframework.web.bind.annotation.*;
import workshop.architecture.clean.personnel.application.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/employees")
public class EmployeesApi {

    private @Resource GetEmployeeByCurrentUserUseCase getEmployeeByCurrentUserUseCase;

    @GetMapping
    public EmployeeOutput get() {
        return getEmployeeByCurrentUserUseCase.execute();
    }

}
