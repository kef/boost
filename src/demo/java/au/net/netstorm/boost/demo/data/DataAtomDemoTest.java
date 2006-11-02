package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.atom.DataAtomTestChecker;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

// SUGGEST Full IOC support allows copy-in/copy-out by interjecting proxies without the laborious code.
public final class DataAtomDemoTest extends TestCase {
    private static final FieldSpec STRING_PROPERTY = new DefaultFieldSpec("guitar", String.class);
    private static final FieldSpec PRIMITIVE_PROPERTY = new DefaultFieldSpec("goodPlayer", boolean.class);
    private static final FieldSpec ARRAY_PROPERTY = new DefaultFieldSpec("integers", Integer[].class);
    private static final FieldSpec PRIMITIVE_ARRAY_PROPERTY = new DefaultFieldSpec("bytes", byte[].class);
    private static final FieldSpec ARRAY_OF_ARRAYS_PROPERTY = new DefaultFieldSpec("floaters", float[][].class);
    private static final FieldSpec BASIC_PROPERTY = new DefaultFieldSpec("basic", BasicInterface.class);
    private static final FieldSpec NON_DATA_PROPERTY = new DefaultFieldSpec("nonImmutable", NonImmutableInterface.class);
    private static final FieldSpec[] SINGLE_STRING_PROPERTY = {STRING_PROPERTY};
    private static final FieldSpec[] SINGLE_PRIMITIVE_PROPERTY = {PRIMITIVE_PROPERTY};
    private static final FieldSpec[] SINGLE_ARRAY_PROPERTY = {ARRAY_PROPERTY};
    private static final FieldSpec[] SINGLE_PRIMITIVE_ARRAY_PROPERTY = { PRIMITIVE_ARRAY_PROPERTY };
    private static final FieldSpec[] SINGLE_ARRAY_OF_ARRAYS_PROPERTY = {ARRAY_OF_ARRAYS_PROPERTY};
    private static final FieldSpec[] COMPLEX_PROPERTIES = {STRING_PROPERTY, BASIC_PROPERTY};
    private static final FieldSpec[] COMPLEX_NON_DATA_PROPERTIES = {STRING_PROPERTY, NON_DATA_PROPERTY};
    private static final String MESSAGE_METHODS_MUST_BE_PUBLIC_INSTANCE_OR_PRIVATE = "Method getGuitar() violates the constraint that all methods must be public non-static or private.";
    private AtomTestChecker checker = new DataAtomTestChecker();

    // SUGGEST Odd message when the class is not public.
    // SUGGEST Test utility should force data object to implement interface (?).

    public void testGoodAtoms() {
        checkGood(BasicData.class, SINGLE_STRING_PROPERTY);
        checkGood(BasicArrayData.class, SINGLE_ARRAY_PROPERTY);
        checkGood(PrimitiveArrayData.class, SINGLE_PRIMITIVE_ARRAY_PROPERTY);
        checkGood(PrimitiveBasicData.class, SINGLE_PRIMITIVE_PROPERTY);
        checkGood(BasicNonFinalFieldsData.class, SINGLE_STRING_PROPERTY);
        checkGood(ManyPrivateMethodsBasicData.class, SINGLE_STRING_PROPERTY);
        checkGood(DefaultBasicInterfaceData.class, SINGLE_STRING_PROPERTY);
        checkGood(NestedInterfacedData.class, COMPLEX_PROPERTIES);
    }

    public void testBadAtoms() {
        checkBad(NotPrimordialData.class, "NotPrimordialData is not a subclass of Primordial.");
        checkBad(MustBeAClassData.class, "Data atoms must be a class not an interface.  The Data atom can implement interfaces.");
        checkBad(ConstructorParameterCountMismatchData.class, "Constructor must have 1 argument(s) matching the properties.  Instead it appears to have 2 arguments(s).");
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
        checkBad(ReturnValueIncorrectData.class, "Method getGuitar() should return the same value as passed in to the constructor.  Instead it returned (You picked the wrong string).");
        checkBad(NestedWithNonImmutablePartsIllegalData.class, COMPLEX_NON_DATA_PROPERTIES, "NonImmutableInterface is not immutable.  All properties must be immutable.  This means they either implement Immutable/Data or are known immutable types.");
        checkBad(NullsAreIllegalData.class, "We do not allow nulls in Data atoms.  You must throw an IllegalArgumentException when parameter (String) at position 0 in the constructor is null.");
        checkBad(NoArrayCopyOnAccessIllegalData.class, SINGLE_ARRAY_PROPERTY, "Array was not copied on access.  Arrays must be copied on create and on each access.  Try using arrayRef.clone().");
        checkBad(NoArrayCopyOnCreateIllegalData.class, SINGLE_ARRAY_PROPERTY, "Array was not copied on create.  Arrays must be copied on create and on each access.  Try using arrayRef.clone().");
        checkBad(ArrayNotTheSameIllegalData.class, SINGLE_ARRAY_PROPERTY, "Elements of array not the same.  Arrays must be copied on create and on each access.  Try using arrayRef.clone().");
        checkBad(ArrayOfArraysIllegalData.class, SINGLE_ARRAY_OF_ARRAYS_PROPERTY, "float(array of arrays) is not immutable.  All properties must be immutable.  This means they either implement Immutable/Data or are known immutable types.");
    }

    private void checkGood(Class cls, FieldSpec[] fields) {
        checker.checkAtom(cls, fields);
    }

    private void checkBad(Class cls, String expectedMsg) {
        checkBad(cls, SINGLE_STRING_PROPERTY, expectedMsg);
    }

    private void checkBad(Class cls, FieldSpec[] fields, String expectedMsg) {
        try {
            checker.checkAtom(cls, fields);
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
        throw new RuntimeException("Test failed, however we throw this exception to distinguish this test failing versus the data test checker failing.");
    }
}
