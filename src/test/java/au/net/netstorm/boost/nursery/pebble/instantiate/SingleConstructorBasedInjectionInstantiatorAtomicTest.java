package au.net.netstorm.boost.nursery.pebble.instantiate;

import junit.framework.TestCase;

public final class SingleConstructorBasedInjectionInstantiatorAtomicTest extends TestCase {
    private Instantiator instantiator = new SingleConstructorBasedInjectionInstantiator();

    public void testInstantiate() {
        checkInstantiate("Hi");
        checkInstantiate("There");
    }

    private void checkInstantiate(String parameter) {
        Class type = TestObject.class;
        Object[] parameters = {parameter};
        Object ref = instantiator.instantiate(type, parameters);
        TestObject expected = new TestObject(parameter);
        assertEquals(expected, ref);
    }
}
