package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.MutableBinding;

public final class DefaultSingleMakerAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private SingleMaker subject;
    MutableBinding bindingMock;

    public void setUpFixtures() {
        subject = new DefaultSingleMaker(bindingMock);
    }

    public void testAsSingle() {
        expect.oneCall(bindingMock, VOID, "makeSingleton");
        subject.asSingle();
    }
}
