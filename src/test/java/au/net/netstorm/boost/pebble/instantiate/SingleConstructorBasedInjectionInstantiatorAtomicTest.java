package au.net.netstorm.boost.pebble.instantiate;

import au.net.netstorm.boost.test.cases.BoooostCase;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.Implementation;

public final class SingleConstructorBasedInjectionInstantiatorAtomicTest extends BoooostCase {
    private Instantiator instantiator = new SingleConstructorBasedInjectionInstantiator();

    public void testInstantiate() {
        checkInstantiate("Hi");
        checkInstantiate("There");
    }

    private void checkInstantiate(String parameter) {
        Class type = TestObjectimoto.class;
        Object[] parameters = {parameter};
        Implementation implementation = new DefaultImplementation(type);
        Object ref = instantiator.instantiate(implementation, parameters);
        TestObjectimoto expected = new TestObjectimoto(parameter);
        assertEquals(expected, ref);
    }
}
