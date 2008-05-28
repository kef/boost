package au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.testdata.Dummy;

public final class DefaultInjectionSiteBuilderAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private InjectionSiteBuilder subject;
    FieldTestUtil fielder;
    InjectionSiteChecker checker;
    InjectionType typeMock;
    InjectionTypeBuilder builderMock;

    public void setUpFixtures() {
        subject = new DefaultInjectionSiteBuilder();
        fielder.setInstance(subject, "builder", builderMock);
    }

    public void testBuildField() {
        Field field = fielder.get(Dummy.class, "x");
        Type type = field.getGenericType();
        expect.oneCall(builderMock, typeMock, "build", type);
        InjectionSite result = subject.build(field);
        checker.checkSite(result, Dummy.class, typeMock, "x");
    }

    public void testBuildConstructor() {
        // FIX 2394 drive me up
    }
}
