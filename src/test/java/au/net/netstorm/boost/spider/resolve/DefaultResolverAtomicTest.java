package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolverAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    private static final Implementation NO_CONTEXT = new DefaultImplementation(NoContext.class);
    private static final Class FRUITY = Fruity.class;
    Interface fruity = new DefaultInterface(FRUITY);
    ResolvedInstance resolvedInstanceMock;
    ResolverEngine resolverEngineMock;
    Object resolved = this;
    Resolver subject;

    public void setUpFixtures() {
        subject = new DefaultResolver(resolverEngineMock);
    }

    public void testResolve() {
        expect.oneCall(resolverEngineMock, resolvedInstanceMock, "resolve", fruity, NO_CONTEXT);
        expect.oneCall(resolvedInstanceMock, resolved, "getRef");
        Object result = subject.resolve(FRUITY);
        assertEquals(resolved, result);
    }
}
