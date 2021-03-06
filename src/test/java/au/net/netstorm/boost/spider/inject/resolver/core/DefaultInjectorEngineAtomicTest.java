package au.net.netstorm.boost.spider.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.gunge.type.ResolvedInstance;
import au.net.netstorm.boost.gunge.type.UnresolvedInstance;
import au.net.netstorm.boost.sledge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.sledge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.sledge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.inject.core.InjectorEngine;
import au.net.netstorm.boost.spider.inject.resolver.field.ResolvableFieldFinder;
import au.net.netstorm.boost.spider.instance.DefaultPartialInstances;
import au.net.netstorm.boost.spider.instance.PartialInstances;

public final class DefaultInjectorEngineAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    InjectorEngine subject;
    EdgeClass classer = new DefaultEdgeClass();
    EdgeField edgeFielder = new DefaultEdgeField();
    EdgeField fielderMock;
    ResolvableFieldFinder fieldFinderMock;
    FieldResolver fieldResolverMock;
    JuicyRock juicy = new JuicyRock();
    UnresolvedInstance unresolvedMock;
    ResolvedInstance lazyBastardMock;
    ResolvedInstance moleyMock;
    Juicy juicyRef;
    Rock rockRef;
    Field fieldJuicy = field("juicy");
    Field fieldRock = field("rock");
    Field[] fields = {fieldJuicy, fieldRock};
    PartialInstances partialInstances = new DefaultPartialInstances();

    public void setUpFixtures() {
        subject = new DefaultInjectorEngine(fieldFinderMock, fieldResolverMock);
        overrideFields();
    }

    public void testInjector() {
        partialInstances.clear();
        expect.oneCall(unresolvedMock, juicy, "getRef");
        expect.oneCall(fieldFinderMock, fields, "find", juicy);
        setupFieldResolve(lazyBastardMock, fieldJuicy, juicyRef);
        setupFieldResolve(moleyMock, fieldRock, rockRef);
        subject.inject(unresolvedMock);
    }

    private void setupFieldResolve(ResolvedInstance resolvedInstance, Field field, Object ref) {
        expect.oneCall(fieldResolverMock, resolvedInstance, "resolve", field);
        expect.oneCall(resolvedInstance, ref, "getRef");
        expect.oneCall(fielderMock, VOID, "set", field, juicy, ref);
    }

    private Field field(String name) {
        Class cls = juicy.getClass();
        return classer.getDeclaredField(cls, name);
    }

    private void overrideFields() {
        Class cls = subject.getClass();
        Field field = classer.getDeclaredField(cls, "fielder");
        field.setAccessible(true);
        edgeFielder.set(field, subject, fielderMock);
    }
}
