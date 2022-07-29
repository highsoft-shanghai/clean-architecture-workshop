package workshop.architecture.clean.salarying.gateways.ohs;

import org.springframework.web.bind.annotation.*;
import workshop.architecture.clean.salarying.application.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/salary-reports")
public class SalariesApi {

    private @Resource SearchSalaryByCurrentUserUseCase searchSalaryByCurrentUserUseCase;

    @GetMapping
    public List<SalaryOutput> search(@RequestParam Integer year, @RequestParam Integer month) {
        return searchSalaryByCurrentUserUseCase.execute(year, month);
    }

}
