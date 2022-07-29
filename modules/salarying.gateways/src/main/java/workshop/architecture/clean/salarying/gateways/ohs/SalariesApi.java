package workshop.architecture.clean.salarying.gateways.ohs;

import org.springframework.web.bind.annotation.*;
import workshop.architecture.clean.salarying.application.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/salaries")
public class SalariesApi {

    private @Resource SearchSalaryByCurrentUserUseCase searchSalaryByCurrentUserUseCase;

    @GetMapping("/current")
    public SalaryOutput search(@RequestParam Integer year, @RequestParam Integer month) {
        return searchSalaryByCurrentUserUseCase.execute(year, month);
    }

}
