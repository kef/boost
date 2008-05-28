package au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.Constructor;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.testdata.Dummy;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;

public final class DefaultInjectionSiteBuilderAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private InjectionSiteBuilder subject;
    FieldTestUtil fielder;
    EdgeClass classer;
    InjectionSiteChecker checker;
    InjectionType typeMock;
    InjectionTypeBuilder builderMock;

    public void setUpFixtures() {
        subject = new DefaultInjectionSiteBuilder();
        fielder.setInstance(subject, "builder", builderMock);
    }

    public void testBuildRoot() {
        InjectionSite result = subject.build(typeMock);
        assertEquals(true, result instanceof RootInjectionSite);
    }

    public void testBuildField() {
        Field field = fielder.get(Dummy.class, "x");
        Type type = field.getGenericType();
        expect.oneCall(builderMock, typeMock, "build", type);
        InjectionSite result = subject.build(field);
        checker.checkSite(result, Dummy.class, typeMock, "x");
    }

    public void testBuildConstructor() {
        Constructor<?> ctor = classer.getConstructor(Dummy.class, String.class);
        expect.oneCall(builderMock, typeMock, "build", String.class);
        InjectionSite[] results = subject.build(ctor);
        assertEquals(1, results.length);
        checker.checkSite(results[0], Dummy.class, typeMock, "arg0");
    }
}
