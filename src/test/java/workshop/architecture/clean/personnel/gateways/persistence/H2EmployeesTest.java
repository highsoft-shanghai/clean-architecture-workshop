package workshop.architecture.clean.personnel.gateways.persistence;

import org.junit.jupiter.api.*;
import workshop.architecture.clean.personnel.domain.Projects;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class H2EmployeesTest {

    private Projects projects;

    @BeforeEach
    void setUp() {
        projects = mock(Projects.class);
        when(projects.findByIdAndEmployeeId(anyString(), anyString())).thenReturn(Optional.empty());
    }

    @Test
    void should_get_one_project_in_one_employee() {
        assertEquals(Optional.empty(), new H2Employees.EmployeeProjects("1", projects).findOne("134"));
    }

}
