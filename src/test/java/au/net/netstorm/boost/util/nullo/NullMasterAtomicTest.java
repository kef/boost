package au.net.netstorm.boost.util.nullo;

import au.net.netstorm.boost.test.checker.AssertThrows;
import au.net.netstorm.boost.test.checker.Block;
import au.net.netstorm.boost.test.checker.DefaultAssertThrows;
import junit.framework.TestCase;

public class NullMasterAtomicTest extends TestCase {
    private NullMaster nullMaster = new NullMaster();
    private AssertThrows throwsMaster = new DefaultAssertThrows();

    public void testNoException() {
        nullMaster.check(this, null);
    }

    // FIXME: SC523 Replace with normal test method.
    public void testNull() {
        checkFailNull("foo");
        checkFailNull("bar");
    }

    private void checkFailNull(final String parameter) {
        final String expectedMessage = " parameter should not be null";
        throwsMaster.assertThrows(IllegalArgumentException.class, parameter + expectedMessage, new Block() {
            public void execute() throws Throwable {
                nullMaster.check(null, parameter);
            }
        });
    }
}
