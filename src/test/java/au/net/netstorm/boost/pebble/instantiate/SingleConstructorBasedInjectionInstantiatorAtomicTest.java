package au.net.netstorm.boost.pebble.instantiate;

import au.net.netstorm.boost.test.automock.BoooostCase;

public final class SingleConstructorBasedInjectionInstantiatorAtomicTest extends BoooostCase {
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
