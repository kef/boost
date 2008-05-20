package au.net.netstorm.boost.nursery.eight.legged.spider.provider.core;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.ResolvedInstance;
import au.net.netstorm.boost.gunge.type.UnresolvedInstance;

public final class SingleProviderAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private Provider subject;
    FieldTestUtil fielder;
    Implementation implMock;
    Provider multiMock;
    ResolvedInstance resolvedMock;
    UnresolvedInstance unresolvedMock;

    public void setUpFixtures() {
        subject = new SingleProvider(implMock);
        fielder.setInstance(subject, "multi", multiMock);
    }

    public void testNu() {
        Object args = new Object[] {resolvedMock};
        expect.oneCall(multiMock, unresolvedMock, "nu", args);
        checkNu();
        checkNu();
    }

    private void checkNu() {
        UnresolvedInstance result = subject.nu(resolvedMock);
        assertSame(unresolvedMock, result);
    }
}
