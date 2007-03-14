package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.pebble.core.PebbleProvider;
import au.net.netstorm.boost.pebble.type.Implementation;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultFieldResolverAtomicTest extends InteractionTestCase {
    private static final Class IMPLEMENTATION = VeryHappyChap.class;
    private static final VeryHappyChap INSTANCE = new VeryHappyChap();
    private final EdgeClass classer = new DefaultEdgeClass();
    private FieldResolver subject;
    private Field field = someField();
    private Interface iface = new DefaultInterface(HappyChap.class);
    private MockExpectations expect;
    private Resolver resolver;
    private PebbleProvider provider;
    private Implementation implementation;

    public void setupSubjects() {
        subject = new DefaultFieldResolver(resolver, provider);
    }

    public void testResolve() {
        expect.oneCall(resolver, implementation, "resolve", iface);
        expect.oneCall(implementation, IMPLEMENTATION, "getImpl");
        expect.oneCall(provider, INSTANCE, "provide", IMPLEMENTATION, new Object[]{});
        Object result = subject.resolve(field);
        assertEquals(INSTANCE, result);
    }

    private Field someField() {
        return classer.getDeclaredField(Gary.class, "happyChap");
    }
}
