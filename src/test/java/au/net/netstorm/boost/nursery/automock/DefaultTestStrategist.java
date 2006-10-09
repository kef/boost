package au.net.netstorm.boost.nursery.automock;

import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Constructor;

import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;

public final class DefaultTestStrategist implements TestStrategist {
    private final ReflectMaster reflector = new DefaultReflectMaster();
    private final EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();
    private final Map strategies = new HashMap();

    {
        strategies.put(MockTestCase.class, MockTestStrategy.class);
    }

    public TestStrategy determineStrategy(Object testCase) {
        determineTestType(testCase);
        // FIX SC525 We have to do a bit more than this!  Determine type.
        Class cls = (Class) strategies.get(MockTestCase.class);
        return create(cls, testCase);
    }

    private TestStrategy create(Class cls, Object testCase) {
        Constructor constructor = reflector.getConstructor(cls);
        Object[] params = { testCase };
        return (TestStrategy) edgeConstructor.newInstance(constructor, params);
    }

    private void determineTestType(Object testCase) {
        // FIX SC525 Complete.
        throw new UnsupportedOperationException();
    }
}
