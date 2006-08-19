package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.test.atom.DataTestChecker;
import au.net.netstorm.boost.test.atom.DefaultDataTestChecker;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

public final class DataDemoTest extends TestCase {
    private DataTestChecker dataChecker = new DefaultDataTestChecker();
    private static final FieldSpec[] NO_FIELDS = {};
    private static final FieldSpec STRING_PROPERTY = new DefaultFieldSpec("guitar", String.class);
    private static final FieldSpec[] SINGLE_STRING_PROPERTY = {STRING_PROPERTY};
    private static final String MESSAGE_METHODS_MUST_BE_PUBLIC_INSTANCE_OR_PRIVATE = "All methods must be public non-static or private.  Method getGuitar() violates this constraint.";

    public void testBasic() {
        FieldSpec f1 = new DefaultFieldSpec("frog", String.class);
        FieldSpec[] fields = {f1};
        dataChecker.checkIsData(BasicData.class, fields);
    }

    // FIX SC600 Test only a single constructor.
    public void testBadDataAtoms() {
        checkData(NotPrimordialData.class, NO_FIELDS, "NotPrimordialData is not a subclass of Primordial");
        checkData(ConstructorParameterCountMismatchData.class, "Constructor must have 1 argument(s).  Instead it appears to have 0 arguments(s).");
        checkData(ConstructorParameterMismatchData.class, "For constructor parameter 0 we expected:<class java.lang.String> but was:<class java.lang.Integer>");
        checkData(ProtectedMethodsIllegalData.class, MESSAGE_METHODS_MUST_BE_PUBLIC_INSTANCE_OR_PRIVATE);
        checkData(PackagePrivateMethodsIllegalData.class, MESSAGE_METHODS_MUST_BE_PUBLIC_INSTANCE_OR_PRIVATE);
        checkData(PublicStaticMethodsIllegalData.class, MESSAGE_METHODS_MUST_BE_PUBLIC_INSTANCE_OR_PRIVATE);
        checkData(MethodWithArgumentsIllegalData.class, "Method getGuitar() has arguments.  All property accessor methods must have no arguments");
        checkData(IncorrectlyNamedPropertyGetterData.class, "Method getGuitar() expected but not found.");
        checkData(IncorrectlyScopedPropertyGetterData.class, "Method getGuitar() must be a public instance method.");
    }

    private void checkData(Class cls, String expectedMsg) {
        checkData(cls, SINGLE_STRING_PROPERTY, expectedMsg);
    }

    private void checkData(Class cls, FieldSpec[] fields, String expectedMsg) {
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
