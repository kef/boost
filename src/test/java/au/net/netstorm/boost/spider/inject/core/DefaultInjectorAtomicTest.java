package au.net.netstorm.boost.spider.inject.core;

import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public final class DefaultInjectorAtomicTest extends InteractionTestCase implements HasFixtures, LazyFields {
    Injector subject;
    Object ref;
    InjectorEngine engineMock;
    UnresolvedInstance unresolved;

    public void setUpFixtures() {
        unresolved = new DefaultBaseReference(ref);
        subject = new DefaultInjector(engineMock);
    }

    public void testInjector() {
        expect.oneCall(engineMock, MockExpectations.VOID, "inject", unresolved);
        subject.inject(ref);
    }
}
