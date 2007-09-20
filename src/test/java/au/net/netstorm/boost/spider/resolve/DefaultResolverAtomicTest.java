package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.spider.registry.ImplementationRef;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolverAtomicTest extends InteractionTestCase implements HasFixtures, LazyFields {
    private static final Class FRUITY = Fruity.class;
    Resolver subject;
    ResolverEngine resolverEngineMock;
    ResolvedInstance resolvedInstanceMock;
    Interface fruity = new DefaultInterface(FRUITY);
    Object resolved = this;

    public void setUpFixtures() {
        subject = new DefaultResolver(resolverEngineMock);
    }

    public void testResolve() {
        expect.oneCall(resolverEngineMock, resolvedInstanceMock, "resolve", fruity, ImplementationRef.EMPTY);
        expect.oneCall(resolvedInstanceMock, resolved, "getRef");
        Object result = subject.resolve(FRUITY);
        assertEquals(resolved, result);
    }
}
