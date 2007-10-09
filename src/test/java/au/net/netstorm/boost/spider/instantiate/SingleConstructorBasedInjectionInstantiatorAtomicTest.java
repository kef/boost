package au.net.netstorm.boost.spider.instantiate;

import au.net.netstorm.boost.test.core.BoooostCase;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

// FIX 1977 Rewrite this.  Modify the InstantiationException to take the class and parameters.
public final class SingleConstructorBasedInjectionInstantiatorAtomicTest extends BoooostCase {
    private static final Implementation TEST_IMPLEMENTATION = new DefaultImplementation(TestObjectimoto.class);
    private Instantiator subject = new SingleConstructorBasedInjectionInstantiator();

    public void testInstantiate() {
        checkInstantiate("Hi");
        checkInstantiate("There");
    }

    public void testParameterTypeMismatchFailure() {
        Integer parameter = new Integer(5);
        try {
            instantiate(TEST_IMPLEMENTATION, parameter);
            fail();
        } catch (InstantiationException expected) {
            String expectedMessage = makeFailureMessage();
            String actualMessage = expected.getMessage();
            assertEquals(expectedMessage, actualMessage);
        }
    }

    private String makeFailureMessage() {
        return "Unable to construct a " + TEST_IMPLEMENTATION.getImpl() + " : {}";
    }

    private void checkInstantiate(String parameter) {
        UnresolvedInstance expected = buildExpected(parameter);
        UnresolvedInstance result = instantiate(TEST_IMPLEMENTATION, parameter);
        assertEquals(expected, result);
    }

    private UnresolvedInstance instantiate(Implementation implementation, Object parameter) {
        Object[] parameters = {parameter};
        return subject.instantiate(implementation, parameters);
    }

    private UnresolvedInstance buildExpected(String parameter) {
        TestObjectimoto expected = new TestObjectimoto(parameter);
        return new DefaultBaseReference(expected);
    }
}
