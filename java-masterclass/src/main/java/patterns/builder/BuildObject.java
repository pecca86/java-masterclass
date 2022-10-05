package patterns.builder;

public class BuildObject {

    private String buildableString;

    public BuildObject(String buildableString) {
        this.buildableString = buildableString;
    }

    public BuildObject appendPrefix(String prefix) {
        this.buildableString = this.buildableString + prefix;
        return this;
    }

    public BuildObject appendPayload(String payload) {
        this.buildableString = this.buildableString + payload;
        return this;
    }

    public BuildObject appendSuffix(String suffix) {
        this.buildableString = this.buildableString + suffix;
        return this;
    }

    @Override
    public String toString() {
        return  buildableString;
    }
}
