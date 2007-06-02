package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolverAtomicTest extends InteractionTestCase implements HasSubjects, UsesAutoMocks {
    private static final Class FRUITY = Fruity.class;
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
        expect.oneCall(resolverEngine, resolvedInstance, "resolve", fruity, null);
        expect.oneCall(resolvedInstance, resolved, "getRef");
        Object result = subject.resolve(FRUITY);
        assertEquals(resolved, result);
    }
}
