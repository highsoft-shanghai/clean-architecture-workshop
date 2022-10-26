package workshop.architecture.clean.frameworks.domain.core.archtype;

public interface One<Aggregate extends workshop.architecture.clean.frameworks.domain.core.archtype.Aggregate> {

    Aggregate get();

    String id();

    void add(Aggregate aggregate);

    void callOff();

}
