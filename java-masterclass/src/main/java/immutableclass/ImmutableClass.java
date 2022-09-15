package immutableclass;

public record ImmutableClass(int age, String name) implements Comparable<ImmutableClass> {

    @Override
    public int compareTo(ImmutableClass o) {
        return this.age() - o.age();
    }
}
