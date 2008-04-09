package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.nursery.util.type.DefaultInterface;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolverAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    Interface fruity = new DefaultInterface(Fruity.class);
    ResolvedInstance resolvedInstanceMock;
    ResolverEngine resolverEngineMock;
    Fruity resolvedDummy;
    Resolver subject;

    public void setUpFixtures() {
        subject = new DefaultResolver(resolverEngineMock);
    }

    public void testReinstate() {
        // FIX ()   2237 Reinstate.
    }

// FIX ()   2237 Reinstate.
/*
    public void testResolve() {
        expect.oneCall(resolverEngineMock, resolvedInstanceMock, "resolve", NO_CONTEXT, fruity);
        expect.oneCall(resolvedInstanceMock, resolvedDummy, "getRef");
        Fruity result = subject.resolve(Fruity.class);
        assertEquals(resolvedDummy, result);
    }
*/
}
