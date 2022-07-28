package workshop.architecture.clean;

import org.springframework.boot.test.context.SpringBootTest;
import workshop.architecture.clean.frameworks.test.web.RestTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class IntegrationTest extends RestTest {
}
