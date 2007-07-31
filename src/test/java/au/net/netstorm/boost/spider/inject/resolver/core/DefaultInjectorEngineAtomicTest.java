package au.net.netstorm.boost.spider.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.spider.inject.core.InjectorEngine;
import au.net.netstorm.boost.spider.inject.resolver.field.ResolvableFieldFinder;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.test.automock.MockExpectations;
import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public final class DefaultInjectorEngineAtomicTest extends InteractionTestCase implements HasFixtures, LazyFields {
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
    Juicy juicyRefMock;
    Rock rockRef;
    Field fieldJuicy = field("juicy");
    Field fieldRock = field("rock");
    Field[] fields = {fieldJuicy, fieldRock};

    public void setUpFixtures() {
        subject = new DefaultInjectorEngine(fieldFinderMock, fieldResolverMock);
        overrideFields();
    }

    public void testInjector() {
        expect.oneCall(unresolvedMock, juicy, "getRef");
        expect.oneCall(fieldFinderMock, fields, "find", juicy);
        expect.oneCall(fieldResolverMock, lazyBastardMock, "resolve", fieldJuicy);
        expect.oneCall(fieldResolverMock, moleyMock, "resolve", fieldRock);
        expect.oneCall(lazyBastardMock, juicyRefMock, "getRef");
        expect.oneCall(moleyMock, rockRef, "getRef");
        expect.oneCall(fielderMock, MockExpectations.VOID, "set", fieldJuicy, juicy, juicyRefMock);
        expect.oneCall(fielderMock, MockExpectations.VOID, "set", fieldRock, juicy, rockRef);
        subject.inject(unresolvedMock);
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
