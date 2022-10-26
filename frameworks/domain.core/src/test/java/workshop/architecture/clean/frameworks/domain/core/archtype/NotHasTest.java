package workshop.architecture.clean.frameworks.domain.core.archtype;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

class NotHasTest {

    @Test
    void should_not_has_operate() {
        Aggregates<ListManyTest.TestAggregate> impl = mock(Aggregates.class);
        when(impl.get(anyString())).thenReturn(new ListManyTest.TestAggregate());
        NotHasOne<ListManyTest.TestAggregate> aggregate = new NotHasOne<>("1", impl);
        assertEquals("1", aggregate.get().id());
        assertEquals("1", aggregate.get().id());
        aggregate.add(new ListManyTest.TestAggregate());
        aggregate.callOff();
        assertNull(aggregate.id());
        then(impl).should(only()).get(anyString());
    }

}
