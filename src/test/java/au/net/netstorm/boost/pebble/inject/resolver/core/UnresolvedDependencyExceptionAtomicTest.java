package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.test.automock.BoooostCase;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

// FIX 1715 Stitch in.
public final class UnresolvedDependencyExceptionAtomicTest extends BoooostCase {
    private static final Interface INTERFACE = new DefaultInterface(LazyBastard.class);

    public void testException() {
        new UnresolvedDependencyException(INTERFACE);
    }
}
