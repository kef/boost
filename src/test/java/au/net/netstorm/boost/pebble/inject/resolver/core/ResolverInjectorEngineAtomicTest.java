package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.pebble.inject.core.InjectorEngine;
import au.net.netstorm.boost.pebble.inject.resolver.field.ResolverFieldFinder;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public final class ResolverInjectorEngineAtomicTest extends InteractionTestCase {
    InjectorEngine subject;
    EdgeClass classer = new DefaultEdgeClass();
    EdgeField edgeFielder = new DefaultEdgeField();
    EdgeField fielder;
    ResolverFieldFinder fieldFinder;
    FieldResolver fieldResolver;
    JuicyRock juicy = new JuicyRock();
    UnresolvedInstance unresolved;
    Instance lazyBastard;
    Instance moley;
    Juicy juicyRef;
    Rock rockRef;
    Field fieldJuicy = field("juicy");
    Field fieldRock = field("rock");
    Field[] fields = {fieldJuicy, fieldRock};

    public void setupSubjects() {
        subject = new ResolverInjectorEngine(fieldFinder, fieldResolver);
        overrideFields();
    }

    public void testInjector() {
        expect.oneCall(unresolved, juicy, "getRef");
        expect.oneCall(fieldFinder, fields, "find", juicy);
        expect.oneCall(fieldResolver, lazyBastard, "resolve", fieldJuicy);
        expect.oneCall(fieldResolver, moley, "resolve", fieldRock);
        expect.oneCall(lazyBastard, juicyRef, "getRef");
        expect.oneCall(moley, rockRef, "getRef");
        expect.oneCall(fielder, VOID, "set", fieldJuicy, juicy, juicyRef);
        expect.oneCall(fielder, VOID, "set", fieldRock, juicy, rockRef);
        subject.inject(unresolved);
    }

    private Field field(String name) {
        Class cls = juicy.getClass();
        return classer.getDeclaredField(cls, name);
    }

    private void overrideFields() {
        Class cls = subject.getClass();
        Field field = classer.getDeclaredField(cls, "fielder");
        field.setAccessible(true);
        edgeFielder.set(field, subject, fielder);
    }
}
