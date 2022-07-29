package workshop.architecture.clean.personnel.gateways.ohs;

import org.springframework.web.bind.annotation.*;
import workshop.architecture.clean.personnel.application.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/employees")
public class EmployeesApi {

    private @Resource GetEmployeeByIdUseCase getEmployeeByIdUseCase;
    private @Resource AddEmployeeUseCase addEmployeeUseCase;

    @GetMapping("/{id}")
    public EmployeeOutput get(@PathVariable String id) {
        return EmployeeOutput.of(getEmployeeByIdUseCase.execute(id));
    }

    @PostMapping
    public void add(@RequestBody EmployeeInput input) {
        addEmployeeUseCase.execute(input);
    }

}
