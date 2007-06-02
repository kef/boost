package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolverAtomicTest extends InteractionTestCase implements HasSubjects, UsesAutoMocks {
    private static final Class FRUITY = Fruity.class;
    private static final Flavour UNFLAVOURED = Flavour.UNFLAVOURED;
    Resolver subject;
    ResolverEngine resolverEngine;
    ResolvedInstance resolvedInstance;
    Interface fruity = new DefaultInterface(FRUITY);
    Object resolved = this;

    public void setupSubjects() {
        subject = new DefaultResolver(resolverEngine);
    }

    public void testResolve() {
        // FIX 1977 Should be real flavour.
        expect.oneCall(resolverEngine, resolvedInstance, "resolve", fruity, UNFLAVOURED);
        expect.oneCall(resolvedInstance, resolved, "getRef");
        Object result = subject.resolve(FRUITY);
        assertEquals(resolved, result);
    }
}
