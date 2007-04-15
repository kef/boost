package au.net.netstorm.boost.spider.instantiate;

import au.net.netstorm.boost.test.cases.BoooostCase;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public final class SingleConstructorBasedInjectionInstantiatorAtomicTest extends BoooostCase {
    private static final Implementation IMPLEMENTATION = new DefaultImplementation(TestObjectimoto.class);
    private Instantiator subject = new SingleConstructorBasedInjectionInstantiator();

    public void testInstantiate() {
        checkInstantiate("Hi");
        checkInstantiate("There");
    }

    private void checkInstantiate(String parameter) {
        UnresolvedInstance expected = buildExpected(parameter);
        Object[] parameters = {parameter};
        UnresolvedInstance unresolved = subject.instantiate(IMPLEMENTATION, parameters);
        assertEquals(expected, unresolved);
    }

    private UnresolvedInstance buildExpected(String parameter) {
        TestObjectimoto expected = new TestObjectimoto(parameter);
        return new DefaultBaseReference(expected);
    }
}
