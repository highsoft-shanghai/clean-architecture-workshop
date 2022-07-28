package workshop.architecture.clean.personnel.gateways.ohs;

import org.springframework.web.bind.annotation.*;
import workshop.architecture.clean.personnel.application.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/accounts")
public class AccountsApi {
    private @Resource FindAccountByIdUseCase findAccountByIdUseCase;

    @GetMapping
    public AccountOutput find(@RequestParam String id) {
        return findAccountByIdUseCase.execute(id);
    }
}
