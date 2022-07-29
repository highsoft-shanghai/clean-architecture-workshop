package workshop.architecture.clean.frameworks.context.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContextTest {

    @Test
    void should_return_general_context() {
        assertEquals("zhangsan", Context.currentUser().id());
        assertEquals("张三", Context.currentUser().name());
    }

}
