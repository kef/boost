package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.util.HashSet;
import java.util.Set;
import au.net.netstorm.boost.pebble.type.Implementation;
import au.net.netstorm.boost.test.automock.BoooostTestCase;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class ExplicitResolverAtomicTest extends BoooostTestCase {
    private final ExplicitResolver subject = new DefaultExplicitResolver();

    {
        subject.add(Set.class, HashSet.class);
    }

    public void testResolve() {
        resolve(subject, Set.class);
    }

    private Implementation resolve(Resolver resolver, Class cls) {
        Interface iface = new DefaultInterface(cls);
        return resolver.resolve(iface);
    }
}
