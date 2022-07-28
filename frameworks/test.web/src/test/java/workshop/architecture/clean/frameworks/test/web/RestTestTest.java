package workshop.architecture.clean.frameworks.test.web;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestTestTest extends IntegrationTest {

    @Test
    void should_be_able_to_call_simple_get() {
        JsonResponse response = get("/web-test/simple-get");
        assertEquals(HttpStatus.OK, response.statusCode());
        assertEquals("John", response.value("$.name"));
    }

}
