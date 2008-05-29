package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

public final class MockClassEquals {
    private final Class<?> expected;

    public MockClassEquals(Class<?> expected) {
        this.expected = expected;
    }

    public int hashCode() {
        return 0;
    }

    public boolean equals(Object o) {
        Class<?> actual = o.getClass();
        return expected == actual;
    }
}
