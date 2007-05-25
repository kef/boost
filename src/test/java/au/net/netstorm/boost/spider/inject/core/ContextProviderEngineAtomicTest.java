package au.net.netstorm.boost.spider.inject.core;

import au.net.netstorm.boost.demo.spider.newer.ResolvedThings;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.ResolvedInstance;

// FIX 54976 Remove.
public final class ContextProviderEngineAtomicTest extends InteractionTestCase implements HasSubjects, UsesAutoMocks {
    ProviderEngine subject;
    ProviderEngine providerEngine;
    Implementation implementation;
    Object[] resolved;
    ResolvedInstance expected;
    ResolvedThings resolvedThings;

    public void setupSubjects() {
        subject = new ContextProviderEngine(providerEngine, resolvedThings);
    }

    public void testProvide() {
        expect.oneCall(resolvedThings, VOID, "clear");
        expect.oneCall(providerEngine, expected, "provide", implementation, resolved);
        expect.oneCall(resolvedThings, VOID, "clear");
        ResolvedInstance actual = subject.provide(implementation, resolved);
        assertEquals(expected, actual);
    }
}
