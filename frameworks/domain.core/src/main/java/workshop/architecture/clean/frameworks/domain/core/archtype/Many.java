package workshop.architecture.clean.frameworks.domain.core.archtype;

import java.util.*;

public interface Many<Aggregate extends workshop.architecture.clean.frameworks.domain.core.archtype.Aggregate> {

    Optional<Aggregate> findOne(String id);

    Collection<Aggregate> getAll();

}
