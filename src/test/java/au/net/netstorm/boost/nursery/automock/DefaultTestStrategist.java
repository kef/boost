package au.net.netstorm.boost.nursery.automock;

import java.util.HashMap;
import java.util.Map;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.util.type.DefaultInterface;

public final class DefaultTestStrategist implements TestStrategist {
    private final ReflectMaster reflector = new DefaultReflectMaster();
    private final EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();
    private final Map strategies = new HashMap();

    {
        strategies.put(MockTestCase.class, MockTestStrategy.class);
    }

    public TestStrategy determineStrategy(Object testCase) {
        // FIX SC525 Push this out to interface.
        Class cls = testCase.getClass();
        if (is(MockTestCase.class, testCase)) return new MockTestStrategy(testCase);
        throw new IllegalStateException("There is no supported test strategy for "+cls);
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
