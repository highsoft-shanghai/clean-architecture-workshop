package workshop.architecture.clean.usecases.personnel;

import org.junit.jupiter.api.*;
import org.springframework.http.HttpStatus;
import workshop.architecture.clean.IntegrationTest;
import workshop.architecture.clean.frameworks.test.web.JsonResponse;
import workshop.architecture.clean.personnel.domain.Account;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetAccountTest extends IntegrationTest {

    private @Resource Account.Accounts accounts;

    @BeforeEach
    void setUp() {
        accounts.add(new Account("1", "John"));
    }

    @Test
    void should_get_account_by_id() {
        JsonResponse response = get("/accounts?id=1");
        assertEquals(HttpStatus.OK, response.statusCode());
        assertEquals("1", response.value("$.id"));
        assertEquals("John", response.value("$.name"));
    }

    @AfterEach
    void tearDown() {
        accounts.clear();
    }

}
