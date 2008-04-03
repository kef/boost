package au.net.netstorm.boost.gunge.atom;

import au.net.netstorm.boost.gunge.core.BoooostCase;

public final class DefaultCaptialiserAtomicTest extends BoooostCase {
    Captialiser subject = new DefaultCaptialiser();

    public void testCaptialise() {
        check("", "");
        check("a", "A");
        check("A", "A");
        check("3", "3");
        check("hello", "Hello");
        check("Hello", "Hello");
        check("hELLO", "HELLO");
        check("HELLO", "HELLO");
    }

    private void check(String input, String expected) {
        String actual = subject.captialise(input);
        assertEquals(expected, actual);
    }
}
