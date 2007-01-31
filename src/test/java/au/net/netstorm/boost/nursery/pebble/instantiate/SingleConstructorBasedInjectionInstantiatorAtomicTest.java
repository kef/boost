package au.net.netstorm.boost.nursery.pebble.instantiate;

import junit.framework.TestCase;

public final class SingleConstructorBasedInjectionInstantiatorAtomicTest extends TestCase {
    private Instantiator instantiator = new SingleConstructorBasedInjectionInstantiator();

    public void testInstantiate() {
        checkInstantiate("Hi");
//        checkInstantiate("There");
        // FIX BREADCRUMB 1665 Complete.
    }

    private void checkInstantiate(String parameter) {
        Class type = String.class;
        Object[] parameters = {parameter};
        Object ref = instantiator.instantiate(type, parameters);
        assertEquals(parameter, ref);
    }
}
