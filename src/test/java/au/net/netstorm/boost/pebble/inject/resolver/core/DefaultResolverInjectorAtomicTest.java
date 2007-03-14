package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.pebble.inject.newer.core.Injector;
import au.net.netstorm.boost.pebble.inject.resolver.field.ResolverFieldFinder;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.MockExpectations;

public final class DefaultResolverInjectorAtomicTest extends InteractionTestCase {
    private MockExpectations expect;
    private Injector subject;
    private final EdgeClass classer = new DefaultEdgeClass();
    private EdgeField edgeFielder = new DefaultEdgeField();
    private EdgeField fielder;
    private ResolverFieldFinder fieldFinder;
    private FieldResolver fieldResolver;
    private JuicyPebble juicy = new JuicyPebble();
    private LazyBastard lazyBastard;
    private CruisyMole moley;
    private Field fieldLazareetus = field("lazareetus");
    private Field fieldCruisyMole = field("moley");
    private Field[] fields = {fieldLazareetus, fieldCruisyMole};

    public void setupSubjects() {
        subject = new ResolverInjector(fieldFinder, fieldResolver);
        overrideFields();
    }

    public void testInjector() {
        expect.oneCall(fieldFinder, fields, "find", juicy);
        expect.oneCall(fieldResolver, lazyBastard, "resolve", fieldLazareetus);
        expect.oneCall(fieldResolver, moley, "resolve", fieldCruisyMole);
        expect.oneCall(fielder, VOID, "set", fieldLazareetus, juicy, lazyBastard);
        expect.oneCall(fielder, VOID, "set", fieldCruisyMole, juicy, moley);
        subject.inject(juicy);
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
