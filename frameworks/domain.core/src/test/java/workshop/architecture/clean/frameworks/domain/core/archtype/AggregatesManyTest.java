package workshop.architecture.clean.frameworks.domain.core.archtype;

import org.junit.jupiter.api.Test;

import java.util.*;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

class AggregatesManyTest {

    @Test
    void should_get_aggregates_with_cached() {
        Aggregates<ListManyTest.TestAggregate> impl = mock(Aggregates.class);
        when(impl.list(any())).thenReturn(newArrayList(new ListManyTest.TestAggregate(), new ListManyTest.TestAggregate()));
        NotHasMany<ListManyTest.TestAggregate> aggregates = new NotHasMany<>(newArrayList("1", "2"), impl);
        List<ListManyTest.TestAggregate> all = aggregates.getAll();
        List<ListManyTest.TestAggregate> all2 = aggregates.getAll();
        then(impl).should(only()).list(any());
        Optional<ListManyTest.TestAggregate> one = aggregates.findOne("1");
        then(impl).should(never()).get(anyString());
    }

    @Test
    void should_create_many_with_aggregates() {
        Aggregates<ListManyTest.TestAggregate> impl = mock(Aggregates.class);
        when(impl.list(newArrayList("1", "2"))).thenReturn(newArrayList(new ListManyTest.TestAggregate(), new ListManyTest.TestAggregate()));
        when(impl.getOptional("1")).thenReturn(Optional.of(new ListManyTest.TestAggregate()));
        NotHasMany<ListManyTest.TestAggregate> aggregates = new NotHasMany<>(newArrayList("1", "2"), impl);
        assertThat(aggregates.findOne("1")).isPresent();
        assertThat(aggregates.findOne("3")).isNotPresent();
    }

    @Test
    void should_add_id_in_not_have() {
        NotHasMany<ListManyTest.TestAggregate> aggregates = new NotHasMany<>(newArrayList("1", "2"), null);
        aggregates.add("3");
        assertThat(aggregates.ids()).containsExactly("1", "2", "3");
    }

    @Test
    void should_remove_id_in_not_have() {
        NotHasMany<ListManyTest.TestAggregate> aggregates = new NotHasMany<>(newArrayList("1", "2"), null);
        aggregates.remove("2");
        assertThat(aggregates.ids()).containsExactly("1");
    }
}
