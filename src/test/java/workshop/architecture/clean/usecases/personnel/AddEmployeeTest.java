package workshop.architecture.clean.usecases.personnel;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.testcontainers.shaded.com.google.common.collect.ImmutableMap;
import workshop.architecture.clean.IntegrationTest;
import workshop.architecture.clean.frameworks.test.web.JsonResponse;
import workshop.architecture.clean.personnel.domain.Employee;

import javax.annotation.Resource;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddEmployeeTest extends IntegrationTest {

    private @Resource Employee.Employees employees;

    @Test
    void should_get_employee_by_id_when_current_employee_login() {
        JsonResponse response = post(
            "/employees",
            ImmutableMap.builder()
                .put("name", "李四")
                .put("birthday", "1990-08-08T15:00:00Z")
                .put("hireDate", "2020-05-07T16:00:00Z")
                .build()
        );

        assertEquals(HttpStatus.OK, response.statusCode());

        Employee employee = employees.get("test-id");
        assertEquals("test-id", employee.id());
        assertEquals("李四", employee.name());
        assertEquals(Instant.parse("1990-08-08T15:00:00Z"), employee.birthday());
        assertEquals(Instant.parse("2020-05-07T16:00:00Z"), employee.hireDate());
    }

}
