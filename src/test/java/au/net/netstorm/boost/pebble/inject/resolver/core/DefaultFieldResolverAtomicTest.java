package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.pebble.core.PebbleProviderEngine;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultFieldResolverAtomicTest extends InteractionTestCase {
    private static final Implementation CLASS_TO_NU = new DefaultImplementation(VeryHappyChap.class);
    private static final VeryHappyChap INSTANCE = new VeryHappyChap();
    private FieldResolver subject;
    private final EdgeClass classer = new DefaultEdgeClass();
    private Field field = someField();
    private Interface iface = new DefaultInterface(HappyChap.class);
    private ImplementationLookup implementationLookup;
    private PebbleProviderEngine provider;

    public void setupSubjects() {
        subject = new DefaultFieldResolver(implementationLookup, provider);
    }

    public void testResolve() {
        expect.oneCall(implementationLookup, CLASS_TO_NU, "find", iface);
        expect.oneCall(provider, INSTANCE, "provide", CLASS_TO_NU, new Object[]{});
        Object result = subject.resolve(field);
        assertEquals(INSTANCE, result);
    }

    private Field someField() {
        return classer.getDeclaredField(Gary.class, "happyChap");
    }
}
