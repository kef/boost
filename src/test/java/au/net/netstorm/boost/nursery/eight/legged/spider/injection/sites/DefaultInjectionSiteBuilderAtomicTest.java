package au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.testdata.Dummy;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionTypeBuilder;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;

public final class DefaultInjectionSiteBuilderAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private InjectionSiteBuilder subject;
    FieldTestUtil fielder;
    EdgeClass classer;
    InjectionSiteChecker checker;
    InjectionType typeMock;
    InjectionTypeBuilder builderMock;

    public void setUpFixtures() {
        subject = new DefaultInjectionSiteBuilder();
        fielder.setInstance(subject, "types", builderMock);
    }

    public void testBuildRoot() {
        InjectionSite result = subject.root(typeMock);
        assertEquals(true, result instanceof DefaultRootInjectionSite);
    }

    public void testBuildField() {
        Field field = fielder.get(Dummy.class, "x");
        Type type = field.getGenericType();
        expectBuildType(type);
        InjectionSite result = subject.fields(field);
        checker.check(result, Dummy.class, typeMock, "x");
    }

    private void expectBuildType(Type type) {
        expect.oneCall(builderMock, typeMock, "build", type);
    }
}
