package au.net.netstorm.boost.nursery.pebble.instantiate;

import junit.framework.TestCase;

public final class ConstructorBasedInjectionInstantiatorAtomicTest extends TestCase {
    private Instantiator instantiator = new ConstructorBasedInjectionInstantiator();

    public void testInstantiate() {
        Class type = String.class;
        String parameter = "Hi";
        Object[] parameters = {parameter};
        Object ref = instantiator.instantiate(type, parameters);
        assertEquals(parameter, ref);
        // FIX BREADCRUMB 1665 Complete.
    }
}
