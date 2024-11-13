package ai;

public enum Model {
    LLAMA_S("llama-3.1-sonar-small-128k-online"),
    LLAMA_L("llama-3.1-sonar-large-128k-online");

    public final String name;

    Model(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
