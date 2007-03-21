package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.pebble.resolve.Resolver;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultFieldResolverAtomicTest extends InteractionTestCase {
    private final EdgeClass classer = new DefaultEdgeClass();
    private Interface happyChap = new DefaultInterface(HappyChap.class);
    private FieldResolver subject;
    private Field field = someField();
    private Resolver resolver;
    private Object resolved;

    public void setupSubjects() {
        subject = new DefaultFieldResolver(resolver);
    }

    public void testResolve() {
        expect.oneCall(resolver, resolved, "resolve", happyChap);
        Object result = subject.resolve(field);
        assertEquals(resolved, result);
    }

    private Field someField() {
        return classer.getDeclaredField(Gary.class, "happyChap");
    }
}
