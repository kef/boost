package au.net.netstorm.boost.nursery.automock;

public final class DefaultTestStrategist implements TestStrategist {
    public TestStrategy determineStrategy(Object testCase) {
        // FIX SC525 Create instance, passing in the test case.
        throw new UnsupportedOperationException();
    }
}
