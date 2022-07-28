package workshop.architecture.clean.frameworks.test.web;

import com.google.common.collect.ImmutableMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/web-test")
public class WebTestController {
    @GetMapping("simple-get")
    public Object simpleGet() {
        return ImmutableMap.builder()
            .put("name", "John")
            .build();
    }
}
