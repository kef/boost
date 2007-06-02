package au.net.netstorm.boost.spider.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.spider.flavour.DefaultFlavour;
import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.spider.resolve.ResolverEngine;
import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultFieldResolverAtomicTest extends InteractionTestCase implements HasSubjects, UsesAutoMocks {
    EdgeClass classer = new DefaultEdgeClass();
    Interface happyChap = new DefaultInterface(HappyChap.class);
    FieldResolver subject;
    ResolverEngine resolver;
    ResolvedInstance resolved;

    public void setupSubjects() {
        subject = new DefaultFieldResolver(resolver);
    }

    public void testResolve() {
        // FIX 1977 Triangulate.
        checkResolve("happyChap");
    }

    private void checkResolve(String fieldName) {
        Flavour flavour = flavour(fieldName);
        Field field = field(fieldName);
        checkResolve(flavour, field);
    }

    private void checkResolve(Flavour flavour, Field field) {
        expect.oneCall(resolver, resolved, "resolve", happyChap, flavour);
        ResolvedInstance result = subject.resolve(field);
        assertEquals(resolved, result);
    }

    private Flavour flavour(String flavour) {
        return new DefaultFlavour(flavour);
    }

    private Field field(String name) {
        return classer.getDeclaredField(Gary.class, name);
    }
}
