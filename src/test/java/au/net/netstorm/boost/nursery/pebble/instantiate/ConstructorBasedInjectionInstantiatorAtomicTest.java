package au.net.netstorm.boost.nursery.pebble.instantiate;

import junit.framework.TestCase;

public final class ConstructorBasedInjectionInstantiatorAtomicTest extends TestCase {
    private Instantiator instantiator = new ConstructorBasedInjectionInstantiator();

    public void testInstantiate() {
        checkInstantiate("Hi");
        // FIX BREADCRUMB 1665 Complete.
    }

    private void checkInstantiate(String parameter) {
        Class type = String.class;
        Object[] parameters = {parameter};
        Object ref = instantiator.instantiate(type, parameters);
        assertEquals(parameter, ref);
    }
}
