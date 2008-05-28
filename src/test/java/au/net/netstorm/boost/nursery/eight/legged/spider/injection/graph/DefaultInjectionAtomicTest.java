package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

// FIX BREADCRUMB 2328 work out test for generic injection node
public final class DefaultInjectionAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private PhasedInjection subject;
    InjectionContext contextMock;
    InjectionSite siteMock;
    InjectionType typeMock;

    public void setUpFixtures() {
        expect.oneCall(siteMock, typeMock, "type");
        subject = new DefaultInjection(siteMock);
    }

    public void testBuildAndApply() {
        // FIX BREADCRUMB 2328 colour me in
//        subject.build();
//        subject.apply();
    }
}