package workshop.architecture.clean.usecases.personnel;

import org.junit.jupiter.api.*;
import org.springframework.http.HttpStatus;
import workshop.architecture.clean.IntegrationTest;
import workshop.architecture.clean.frameworks.test.web.JsonResponse;
import workshop.architecture.clean.personnel.domain.*;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetEmployeeTest extends IntegrationTest {

    private @Resource Projects projects;

    @BeforeEach
    void setUp() {
        projects.add(new Project("1", "zhangsan", "project1"));
        projects.add(new Project("2", "zhangsan", "project2"));
    }

    @Test
    void should_get_employee_by_id_when_current_employee_login() {
        JsonResponse response = get("/employees/zhangsan");
        assertEquals(HttpStatus.OK, response.statusCode());
        assertEquals("zhangsan", response.value("$.id"));
        assertEquals("张三", response.value("$.name"));
        assertEquals(2, response.jsonValues("$.projects").length);
        assertThat(response.jsonValues("$.projects[*].id")).containsExactly("1", "2");
        assertThat(response.jsonValues("$.projects[*].name")).containsExactly("project1", "project2");
    }

    @AfterEach
    void tearDown() {
        projects.clear();
    }

}
