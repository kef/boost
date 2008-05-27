package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.marker.HasFixtures;

// FIX BREADCRUMB 2328 work out test for generic injection node
public final class DefaultInjectionAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Injection subject;
    InjectionContext ctxMock;

    public void setUpFixtures() {
        subject = new DefaultInjection();
    }

    public void testBuildAndApply() {
        // FIX BREADCRUMB 2328 colour me in
        subject.build();
        subject.apply(ctxMock);
    }
}