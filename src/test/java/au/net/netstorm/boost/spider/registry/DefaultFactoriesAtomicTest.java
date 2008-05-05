package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.linkage.Linkage;

public final class DefaultFactoriesAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    Factories subject;
    Factory factoryMock;
    Linkage linkageDummy;

    public void setUpFixtures() {
        subject = new DefaultFactories();
    }

    public void testGet() {
        checkGetFailsNoFactories();
        checkGetHasFactories();
        checkGetSucceeds();
    }

    private void checkGetFailsNoFactories() {
        checkException();
    }

    private void checkGetHasFactories() {
        setUpFactories(false);
        checkException();
    }

    private void checkGetSucceeds() {
        setUpFactories(true);
        Factory actual = subject.find(linkageDummy);
        assertEquals(factoryMock, actual);
    }

    private void setUpFactories(boolean canHandle) {
        subject.add(factoryMock);
        expect.oneCall(factoryMock, canHandle, "canHandle", linkageDummy);
    }

    private void checkException() {
        try {
            subject.find(linkageDummy);
            fail();
        } catch (CannotProvideException expected) { }
    }
}
