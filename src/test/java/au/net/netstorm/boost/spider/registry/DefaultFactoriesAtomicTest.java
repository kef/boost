package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.nursery.spider.registry.CannotProvideException;
import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;

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
