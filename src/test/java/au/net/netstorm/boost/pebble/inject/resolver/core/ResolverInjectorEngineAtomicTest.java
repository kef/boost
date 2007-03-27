package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.pebble.inject.newer.core.InjectorEngine;
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
    JuicyPebble juicy = new JuicyPebble();
    UnresolvedInstance unresolved;
    Instance lazyBastard;
    Instance moley;
    LazyBastard bastardRef;
    CruisyMole moleyRef;
    Field fieldLazareetus = field("lazareetus");
    Field fieldCruisyMole = field("moley");
    Field[] fields = {fieldLazareetus, fieldCruisyMole};

    public void setupSubjects() {
        subject = new ResolverInjectorEngine(fieldFinder, fieldResolver);
        overrideFields();
    }

    public void testInjector() {
        expect.oneCall(unresolved, juicy, "getRef");
        expect.oneCall(fieldFinder, fields, "find", juicy);
        expect.oneCall(fieldResolver, lazyBastard, "resolve", fieldLazareetus);
        expect.oneCall(fieldResolver, moley, "resolve", fieldCruisyMole);
        expect.oneCall(lazyBastard, bastardRef, "getRef");
        expect.oneCall(moley, moleyRef, "getRef");
        expect.oneCall(fielder, VOID, "set", fieldLazareetus, juicy, bastardRef);
        expect.oneCall(fielder, VOID, "set", fieldCruisyMole, juicy, moleyRef);
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
