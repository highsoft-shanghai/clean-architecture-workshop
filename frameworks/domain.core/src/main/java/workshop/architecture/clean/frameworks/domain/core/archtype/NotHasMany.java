package workshop.architecture.clean.frameworks.domain.core.archtype;

import java.util.*;

public class NotHasMany<Aggregate extends workshop.architecture.clean.frameworks.domain.core.archtype.Aggregate> implements Many<Aggregate> {

    private final List<String> ids;
    private final Aggregates<Aggregate> aggregates;
    private Optional<List<Aggregate>> cached;

    public NotHasMany(List<String> ids, Aggregates<Aggregate> aggregates) {
        this.ids = ids;
        this.aggregates = aggregates;
        this.cached = Optional.empty();
    }

    @Override
    public Optional<Aggregate> findOne(String id) {
        if (!ids.contains(id)) return Optional.empty();
        return cached.map(list -> list.stream().filter(o -> o.id().equals(id)).findFirst())
            .orElseGet(() -> aggregates.getOptional(id));
    }

    @Override
    public List<Aggregate> getAll() {
        if (!cached.isPresent()) {
            this.cached = Optional.ofNullable(aggregates.list(this.ids));
        }
        return cached.get();
    }

    public void add(String id) {
        this.ids.add(id);
    }

    public void remove(String id) {
        this.ids.remove(id);
    }

    public List<String> ids() {
        return this.ids;
    }

}
