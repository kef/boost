package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class DefaultResolverAtomicTest extends InteractionTestCase {
    Resolver subject;
    ResolverEngine resolverEngine;

    public void setupSubjects() {
        subject = new DefaultResolver(resolverEngine);
    }

    // FIX 1914 Complete this.
    public void testResolve() {
        Object result = subject.resolve(Fruity.class);
    }
}
