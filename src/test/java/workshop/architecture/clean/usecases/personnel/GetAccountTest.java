package workshop.architecture.clean.usecases.personnel;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import workshop.architecture.clean.IntegrationTest;
import workshop.architecture.clean.frameworks.test.web.JsonResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetAccountTest extends IntegrationTest {

    @Test
    void should_get_account_by_id() {
        JsonResponse response = get("/employees?id=zhangsan");
        assertEquals(HttpStatus.OK, response.statusCode());
        assertEquals("zhangsan", response.value("$.id"));
        assertEquals("张三", response.value("$.name"));
        assertEquals("1990-08-08T15:00:00Z", response.value("$.birthday"));
        assertEquals("2020-05-07T16:00:00Z", response.value("$.hireDate"));
    }

}
