package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolverAtomicTest extends InteractionTestCase {
    private static final Class FRUITY = Fruity.class;
    Resolver subject;
    ResolverEngine resolverEngine;
    ResolvedInstance resolved;
    Interface fruity = new DefaultInterface(FRUITY);

    public void setupSubjects() {
        subject = new DefaultResolver(resolverEngine);
    }

    // FIX 1914 Complete this.
    public void testResolve() {
        expect.oneCall(resolverEngine, resolved, "resolve", fruity);
        Object result = subject.resolve(FRUITY);
    }
}
