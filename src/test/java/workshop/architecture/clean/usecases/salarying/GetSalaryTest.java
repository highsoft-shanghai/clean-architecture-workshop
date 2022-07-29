package workshop.architecture.clean.usecases.salarying;

import org.junit.jupiter.api.*;
import org.springframework.http.HttpStatus;
import workshop.architecture.clean.IntegrationTest;
import workshop.architecture.clean.frameworks.test.web.JsonResponse;
import workshop.architecture.clean.salarying.domain.*;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetSalaryTest extends IntegrationTest {

    private @Resource Salaries salaries;

    @BeforeEach
    void setUp() {
        salaries.add(Salary.create("zhangsan", 2022, 7, 10000.0));
    }

    @Test
    void should_get_salary_by_current_user() {
        JsonResponse response = get("/salaries/current?year=2022&month=7");
        assertEquals(HttpStatus.OK, response.statusCode());
        assertEquals("test-id", response.value("$.id"));
        assertEquals("张三", response.value("$.employeeName"));
        assertEquals(2022, response.<Integer>value("$.year"));
        assertEquals(7, response.<Integer>value("$.month"));
        assertEquals(10000.0, response.<Double>value("$.amount"));
    }

    @AfterEach
    void tearDown() {
        salaries.clear();
    }

}
