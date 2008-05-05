package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.bullet.primmm.BoooostException;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class IllegalCitizenExceptionAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    BoooostException subject;
    Interface marker;
    Implementation impl;

    public void setUpFixtures() {
        subject = new IllegalCitizenException(marker, impl);
    }

    public void testException() {
        String result = subject.getMessage();
        assertEquals("I know you want to be my darling,... \nbut you're not a " + marker + " -> " + impl, result);
    }
}
