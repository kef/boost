package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.test.atom.DataTestChecker;
import au.net.netstorm.boost.test.atom.DefaultDataTestChecker;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

public final class DataDemoTest extends TestCase {
    private DataTestChecker dataChecker = new DefaultDataTestChecker();
    private static final FieldSpec STRING_PROPERTY = new DefaultFieldSpec("guitar", String.class);
    private static final FieldSpec BOOLEAN_PROPERTY = new DefaultFieldSpec("goodPlayer", boolean.class);
    private static final FieldSpec[] SINGLE_STRING_PROPERTY = {STRING_PROPERTY};
    private static final FieldSpec[] SINGLE_BOOLEAN_PROPERTY = {BOOLEAN_PROPERTY};
    private static final String MESSAGE_METHODS_MUST_BE_PUBLIC_INSTANCE_OR_PRIVATE = "Method getGuitar() violates the constraint that all methods must be public non-static or private.";

    public void testGoodAtoms() {
        dataChecker.checkIsData(BasicData.class, SINGLE_STRING_PROPERTY);
        dataChecker.checkIsData(BooleanBasicData.class, SINGLE_BOOLEAN_PROPERTY);
        dataChecker.checkIsData(ManyPrivateMethodsBasicData.class, SINGLE_STRING_PROPERTY);
    }

    public void testBadAtoms() {
        checkBad(NotPrimordialData.class, "NotPrimordialData is not a subclass of Primordial.");
        checkBad(ConstructorParameterCountMismatchData.class, "Constructor must have 1 argument(s).  Instead it appears to have 2 arguments(s).");
        checkBad(ConstructorParameterMismatchData.class, "For constructor parameter 0 we expected:<class java.lang.String> but was:<class java.lang.Integer>");
        checkBad(ProtectedMethodsIllegalData.class, MESSAGE_METHODS_MUST_BE_PUBLIC_INSTANCE_OR_PRIVATE);
        checkBad(PackagePrivateMethodsIllegalData.class, MESSAGE_METHODS_MUST_BE_PUBLIC_INSTANCE_OR_PRIVATE);
        checkBad(PublicStaticMethodsIllegalData.class, MESSAGE_METHODS_MUST_BE_PUBLIC_INSTANCE_OR_PRIVATE);
        checkBad(MethodWithArgumentsIllegalData.class, "Method getGuitar() has arguments.  All property accessor methods must have no arguments");
        checkBad(PropertyGetterIncorrectlyNamedData.class, "Method getGuitar() expected but not found.");
        checkBad(PropertyGetterIncorrectlyScopedData.class, "Method getGuitar() must be a public instance method.");
        checkBad(ExtraPublicMethodsIllegalData.class, "Too many public methods.  Only getters for the specified properties are allowed.");
        checkBad(PropertyReturnTypeMismatchData.class, "Method getGuitar() must return class java.lang.String.");
        checkBad(MultipleConstructorIllegalData.class, "MultipleConstructorIllegalData must have a single constructor which has a parameter for each property.");
    }

    private void checkBad(Class cls, String expectedMsg) {
        checkBad(cls, SINGLE_STRING_PROPERTY, expectedMsg);
    }

    private void checkBad(Class cls, FieldSpec[] fields, String expectedMsg) {
        try {
            dataChecker.checkIsData(cls, fields);
            barf();
        } catch (AssertionFailedError e) {
            checkMessage(e, expectedMsg);
        }
    }

    private void checkMessage(AssertionFailedError e, String expected) {
        String message = e.getMessage();
        assertEquals(expected, message);
    }

    private void barf() {
        throw new RuntimeException("Test failed, however we throw a this exception to distinguish this test failing versus the data test checker failing");
    }
}
