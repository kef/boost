package au.net.netstorm.boost.nursery.automock;

// FIX SC525 Complete this.
public final class MockTestStrategy implements TestStrategy {
    private final Object testCase;

    public MockTestStrategy(Object testCase) {
        this.testCase = testCase;
    }

    public void init() {
        throw new UnsupportedOperationException();
    }

    public void destroy() {
        throw new UnsupportedOperationException();
    }
}