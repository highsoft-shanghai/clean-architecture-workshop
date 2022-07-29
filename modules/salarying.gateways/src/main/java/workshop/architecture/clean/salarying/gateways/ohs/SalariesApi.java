package workshop.architecture.clean.salarying.gateways.ohs;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salaries")
public class SalariesApi {

    @GetMapping("/current")
    public void getCurrent() {

    }

}
