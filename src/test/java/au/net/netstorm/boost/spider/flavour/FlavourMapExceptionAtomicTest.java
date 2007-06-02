package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.primordial.BoostException;
import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;

public final class FlavourMapExceptionAtomicTest extends InteractionTestCase implements HasSubjects, UsesAutoMocks {
    BoostException subject;
    FlavouredInterface flavoured;

    // FIX 1977 Delete comment.
    public void setupSubjects() {
        subject = new FlavouredMapException(flavoured);
    }

    public void testException() {
        String result = subject.getMessage();
        assertEquals("Failed to add flavoured interface " + flavoured, result);
    }

/*
    BoostException subject;
    Interface marker;
    Implementation impl;

    public void setupSubjects() {
        subject = new IllegalCitizenException(marker, impl);
    }

    public void testException() {
        String result = subject.getMessage();
        assertEquals("I know you want to be my darling,... \nbut you're not a " + marker + " -> " + impl, result);
    }
*/
}
