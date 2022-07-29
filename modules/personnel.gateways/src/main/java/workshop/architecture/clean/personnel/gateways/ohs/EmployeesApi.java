package workshop.architecture.clean.personnel.gateways.ohs;

import org.springframework.web.bind.annotation.*;
import workshop.architecture.clean.personnel.application.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/employees")
public class EmployeesApi {

    private @Resource GetEmployeeByCurrentUserUseCase getEmployeeByCurrentUserUseCase;
    private @Resource AddEmployeeUseCase addEmployeeUseCase;

    @GetMapping
    public EmployeeOutput get() {
        return getEmployeeByCurrentUserUseCase.execute();
    }

    @PostMapping
    public void add(@RequestBody EmployeeInput input) {
        addEmployeeUseCase.execute(input);
    }

}
