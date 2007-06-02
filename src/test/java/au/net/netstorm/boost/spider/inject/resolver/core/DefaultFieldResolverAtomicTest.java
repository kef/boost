package au.net.netstorm.boost.spider.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.spider.resolve.ResolverEngine;
import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultFieldResolverAtomicTest extends InteractionTestCase implements HasSubjects, UsesAutoMocks {
    private static final Flavour UNFLAVOURED = Flavour.UNFLAVOURED;
    EdgeClass classer = new DefaultEdgeClass();
    Interface happyChap = new DefaultInterface(HappyChap.class);
    FieldResolver subject;
    Field field = someField();
    ResolverEngine resolver;
    ResolvedInstance resolved;

    public void setupSubjects() {
        subject = new DefaultFieldResolver(resolver);
    }

    public void testResolve() {
        expect.oneCall(resolver, resolved, "resolve", happyChap, UNFLAVOURED); // FIX 1977 Shouldn't be null.
        ResolvedInstance result = subject.resolve(field);
        assertEquals(resolved, result);
    }

    private Field someField() {
        return classer.getDeclaredField(Gary.class, "happyChap");
    }
}
