package workshop.architecture.clean.frameworks.domain.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlobalIdTest {

    @Test
    void should_get_id() {
        assertEquals("test-id", GlobalId.generate());
    }

}
