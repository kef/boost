package au.net.netstorm.boost.spider.instantiate;

import au.net.netstorm.boost.gunge.type.DefaultBaseReference;
import au.net.netstorm.boost.gunge.type.DefaultImplementation;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.UnresolvedInstance;
import au.net.netstorm.boost.sniper.core.BoooostCase;

// FIX 1977 Rewrite this.  Modify the InstantiationException to take the class and parameters.
public final class SingleConstructorBasedInjectionInstantiatorAtomicTest extends BoooostCase {
    private static final Implementation TEST_IMPLEMENTATION = new DefaultImplementation(TestObjectimoto.class);
    private static final Object[] NO_PARAMS = {};
    private static final String CLASS_NAME_SUFFIX = "[" + TEST_IMPLEMENTATION.getImpl() + "]" + " : []";
    private static final String COUNT_FAILURE = "Expected 1 parameters, given 0 in constructor for " + CLASS_NAME_SUFFIX;
    private static final String TYPE_FAILURE = "Unable to construct a " + CLASS_NAME_SUFFIX;
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
        } catch (InstantiationException actual) {
            checkException(TYPE_FAILURE, actual);
        }
    }

    public void testParameterCountMismatchFailure() {
        try {
            subject.instantiate(TEST_IMPLEMENTATION, NO_PARAMS);
            fail();
        } catch (InstantiationException actual) {
            checkException(COUNT_FAILURE, actual);
        }
    }

    private void checkException(String expectedMessage, Exception actual) {
        String actualMessage = actual.getMessage();
        assertEquals(expectedMessage, actualMessage);
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
