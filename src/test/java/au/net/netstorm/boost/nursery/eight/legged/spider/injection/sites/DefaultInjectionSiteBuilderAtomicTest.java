package au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public final class DefaultInjectionSiteBuilderAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private InjectionSiteBuilder subject;
    FieldTestUtil fielder;
    InjectionSiteChecker checker;
    InjectionType typeMock;

    public void setUpFixtures() {
        subject = new DefaultInjectionSiteBuilder();
    }

    public void testBuildField() {
        // FIX BREADCRUMB 2394 aaaaaaaaa building this up
//        Field field = fielder.get(Dummy.class, "x");
//        InjectionSite result = subject.build(field);
//        checker.checkSite(result, Dummy.class, typeMock, "x");
    }

    public void testBuildConstructor() {
        // FIX 2394 drive me up
    }
}
