package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolverAtomicTest extends InteractionTestCase implements HasFixtures, LazyFields {
    private static final Flavour UNFLAVOURED = Flavour.UNFLAVOURED;
    private static final Class FRUITY = Fruity.class;
    Resolver subject;
    ResolverEngine resolverEngine;
    ResolvedInstance resolvedInstance;
    Interface fruity = new DefaultInterface(FRUITY);
    Object resolved = this;

    public void setUpFixtures() {
        subject = new DefaultResolver(resolverEngine);
    }

    public void testResolve() {
        expect.oneCall(resolverEngine, resolvedInstance, "resolve", fruity, UNFLAVOURED);
        expect.oneCall(resolvedInstance, resolved, "getRef");
        Object result = subject.resolve(FRUITY);
        assertEquals(resolved, result);
    }
}
