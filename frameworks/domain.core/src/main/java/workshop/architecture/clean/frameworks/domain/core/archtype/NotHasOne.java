package workshop.architecture.clean.frameworks.domain.core.archtype;

import java.util.Optional;

public class NotHasOne<Aggregate extends workshop.architecture.clean.frameworks.domain.core.archtype.Aggregate> implements One<Aggregate> {

    private String id;
    private final Aggregates<Aggregate> aggregates;
    private Optional<Aggregate> cached;

    public NotHasOne(String id, Aggregates<Aggregate> aggregates) {
        this.id = id;
        this.aggregates = aggregates;
        this.cached = Optional.empty();
    }

    @Override
    public Aggregate get() {
        if (!cached.isPresent()) {
            Aggregate aggregate = aggregates.get(id);
            cached = Optional.ofNullable(aggregate);
        }
        return cached.get();
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public void add(Aggregate aggregate) {
        this.id = aggregate.id();
    }

    @Override
    public void callOff() {
        this.id = null;
    }

}

