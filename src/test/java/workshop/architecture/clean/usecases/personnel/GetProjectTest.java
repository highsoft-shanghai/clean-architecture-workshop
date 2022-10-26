package workshop.architecture.clean.usecases.personnel;

import org.junit.jupiter.api.*;
import org.springframework.http.HttpStatus;
import workshop.architecture.clean.IntegrationTest;
import workshop.architecture.clean.frameworks.domain.core.archtype.AlreadyHasOne;
import workshop.architecture.clean.frameworks.test.web.JsonResponse;
import workshop.architecture.clean.personnel.domain.*;

import javax.annotation.Resource;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetProjectTest extends IntegrationTest {

    private @Resource Projects projects;

    @BeforeEach
    void setUp() {
        projects.add(new Project("1", new AlreadyHasOne<>(Employee.restore("zhangsan", "张三", Instant.now(), Instant.now(), null)), "project1"));
    }

    @Test
    void should_get_project_with_employee_id_and_name_details() {
        JsonResponse response = get("/projects/1");
        assertEquals(HttpStatus.OK, response.statusCode());
        assertEquals("1", response.value("$.id"));
        assertEquals("project1", response.value("$.name"));
        assertEquals("zhangsan", response.value("$.employeeId"));
        assertEquals("张三", response.value("$.employeeName"));
    }

    @AfterEach
    void tearDown() {
        projects.clear();
    }

}
