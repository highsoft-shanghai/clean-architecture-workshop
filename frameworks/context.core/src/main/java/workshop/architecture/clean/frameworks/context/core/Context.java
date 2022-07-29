package workshop.architecture.clean.frameworks.context.core;

public class Context {
    public static Identity currentUser() {
        return Identity.general();
    }
}
