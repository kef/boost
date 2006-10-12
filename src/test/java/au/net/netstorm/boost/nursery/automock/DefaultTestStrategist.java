package au.net.netstorm.boost.nursery.automock;

import au.net.netstorm.boost.util.type.DefaultInterface;

public final class DefaultTestStrategist implements TestStrategist {
    public TestStrategy determineStrategy(Class cls) {
        // FIX SC525 Push this out to interface.
        if (is(MockTestCase.class, cls)) return new MockTestStrategy(cls);
        throw new IllegalStateException("There is no supported test strategy for " + cls);
    }

    private boolean is(Class matching, Object testCase) {
        checkIsInterface(matching);
        Class cls = testCase.getClass();
        return matching.isAssignableFrom(cls);
    }

    private void checkIsInterface(Class matching) {
        new DefaultInterface(matching);
    }
}
