package au.net.netstorm.boost.nursery.eight.legged.spider.provider.types;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.spider.instantiate.Instantiator;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.UnresolvedInstance;

public final class ImplProviderAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Provider subject;
    Instantiator instantiatorMock;
    Implementation implMock;
    FieldTestUtil fielder;
    UnresolvedInstance unresolvedMock;

    public void setUpFixtures() {
        subject = new ImplProvider(implMock);
        fielder.setInstance(subject, "instantiator", instantiatorMock);
    }

    public void testNu() {
        Object[] args = {};
        expect.oneCall(instantiatorMock, unresolvedMock, "instantiate", implMock, args);
        checkNu(args);
    }

    private void checkNu(Object[] args) {
        Object result = subject.nu(args);
        assertSame(unresolvedMock, result);
    }
}
