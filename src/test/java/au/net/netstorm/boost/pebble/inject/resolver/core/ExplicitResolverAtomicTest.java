package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.util.Set;
import au.net.netstorm.boost.pebble.type.Implementation;
import au.net.netstorm.boost.test.automock.BoooostTestCase;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class ExplicitResolverAtomicTest extends BoooostTestCase {
    private final Resolver subject = new ExplicitResolver();

    public void testResolve() {
        resolve(Set.class);
    }

    private Implementation resolve(Class cls) {
        Interface iface = new DefaultInterface(cls);
        return subject.resolve(iface);
    }
}
