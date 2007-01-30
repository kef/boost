package au.net.netstorm.boost.nursery.pebble.instantiate;

import junit.framework.TestCase;

public final class ConstructorBasedInjectionInstantiatorAtomicTest extends TestCase {

    public void testInstantiate() {
        Instantiator instantiator = new ConstructorBasedInjectionInstantiator();
        Class type = String.class;
        Object[] parameters = { "Hi" };
        Object ref = instantiator.instantiate(type, parameters);
        // FIX BREADCRUMB 1665 Complete.
    }
}
