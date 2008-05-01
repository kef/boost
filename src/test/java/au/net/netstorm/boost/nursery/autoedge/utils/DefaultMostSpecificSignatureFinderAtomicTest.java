package au.net.netstorm.boost.nursery.autoedge.utils;

import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultMostSpecificSignatureFinderAtomicTest extends LifecycleTestCase
        implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {

    private MostSpecificSignatureFinder subject;
    ConstructorFixture fixture;
    JLSOverloadRules jlsMock;
    EdgeClass classer;

    public void setUpFixtures() {
        subject = new DefaultMostSpecificSignatureFinder();
    }

    public void testFind() {
        expect.oneCall(jlsMock, false, "moreSpecific", fixture.vectortype(), fixture.stacktype());
        assertEquals(true, subject.next(fixture.stackctor()));
        assertEquals(true, subject.next(fixture.vectorctor()));
        assertEquals(fixture.stackctor(), subject.result());
    }
}