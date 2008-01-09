package au.net.netstorm.boost.spider.inject.core;

import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public final class DefaultInjectorAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    Injector subject;
    Object ref;
    InjectorEngine engineMock;
    UnresolvedInstance unresolved;

    public void setUpFixtures() {
        unresolved = new DefaultBaseReference(ref);
        subject = new DefaultInjector(engineMock);
    }

    public void testInjector() {
        expect.oneCall(engineMock, VOID, "inject", unresolved);
        subject.inject(ref);
    }
}
