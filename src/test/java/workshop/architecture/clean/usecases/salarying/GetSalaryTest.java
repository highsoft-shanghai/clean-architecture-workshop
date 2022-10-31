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
        Salary.Employee employee = new Salary.Employee() {
            @Override
            public String id() {
                return "zhangsan";
            }

            @Override
            public Employee get() {
                return new Employee("zhangsan", "张三");
            }
        };
        salaries.add(Salary.create(employee, 2022, 7, 10000.0));
    }

    @Test
    void should_get_salary_by_current_user() {
        JsonResponse response = get("/salary-reports?year=2022&month=7");
        assertEquals(HttpStatus.OK, response.statusCode());
        assertEquals("test-id", response.value("$[0].id"));
        assertEquals("张三", response.value("$[0].employeeName"));
        assertEquals(2022, response.<Integer>value("$[0].year"));
        assertEquals(7, response.<Integer>value("$[0].month"));
        assertEquals(10000.0, response.<Double>value("$[0].amount"));
    }

    @AfterEach
    void tearDown() {
        salaries.clear();
    }

}
