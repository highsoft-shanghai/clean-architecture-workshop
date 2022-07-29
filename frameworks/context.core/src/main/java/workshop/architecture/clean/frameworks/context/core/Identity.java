package workshop.architecture.clean.frameworks.context.core;

public final class Identity {

    private final String id;
    private final String name;

    public static Identity general() {
        return new Identity("zhangsan", "张三");
    }

    private Identity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

}
