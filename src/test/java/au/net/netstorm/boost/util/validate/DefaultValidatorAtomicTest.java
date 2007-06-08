package au.net.netstorm.boost.util.validate;

import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;
import au.net.netstorm.boost.test.automock.UsesExpectations;
import au.net.netstorm.boost.type.util.core.Validator;

public final class DefaultValidatorAtomicTest extends InteractionTestCase implements HasSubjects, UsesAutoMocks, UsesExpectations {
    Validator subject;
    String ref;
    String msg;
    String string;

    public void setupSubjects() {
        subject = new DefaultValidator();
    }

    public void testCheckNotEmptyStringFail() {
        checkCheckNotEmptyString((String) null);
        checkCheckNotEmptyString("");
    }

    private void checkCheckNotEmptyString(String string) {
        try {
            subject.checkNotEmpty(string, msg);
            fail();
        } catch (IllegalArgumentException expected) { }
    }

    public void testCheckNotEmptyStringSucceed() {
        subject.checkNotEmpty(string, msg);
    }

    public void testCheckNotNullFail() {
        try {
            subject.checkNotNull(null, msg);
            fail();
        } catch (IllegalArgumentException expected) { }
    }

    public void testCheckNotNullSucceed() {
        subject.checkNotNull(string, msg);
    }

    public void testCheckNotEmptyIntArrayFail() {
        checkCheckNotEmptyIntArray(null);
        checkCheckNotEmptyIntArray(new int[]{});
    }

    public void testCheckNotEmptyIntArraySucceed() {
        subject.checkNotEmpty(new int[]{1, 2, 3}, msg);
    }

    public void testCheckEmptyString() {
        try {
            subject.checkEmpty(string);
            fail();
        } catch (IllegalArgumentException expected) { }
    }

    public void testCheckEmptyStringFail() {
        subject.checkEmpty(null);
    }

    public void testEmptyObjects() {
        checkEmptyObjects(null, true);
        checkEmptyObjects(new Object[]{}, true);
        checkEmptyObjects(new Object[]{string}, false);
    }

    public void testEmptyString() {
        checkEmptyString(null, true);
        checkEmptyString("", true);
        checkEmptyString(string, false);
    }

    private void checkEmptyString(String string, boolean expected) {
        boolean actual = subject.empty(string);
        assertEquals(expected, actual);
    }

    private void checkEmptyObjects(Object[] objects, boolean expected) {
        boolean actual = subject.empty(objects);
        assertEquals(expected, actual);
    }

    private void checkCheckNotEmptyIntArray(int[] ints) {
        try {
            subject.checkNotEmpty(ints, msg);
            fail();
        } catch (IllegalArgumentException expected) { }
    }
}
