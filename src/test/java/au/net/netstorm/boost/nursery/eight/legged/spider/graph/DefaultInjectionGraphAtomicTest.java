package au.net.netstorm.boost.nursery.eight.legged.spider.graph;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.nursery.eight.legged.spider.guts.InjectionContext;

// FIX BREADCRUMB 2328 work out test for generic injection node
public final class DefaultInjectionGraphAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private InjectionGraph subject;
    InjectionContext ctxMock;

    public void setUpFixtures() {
        subject = new DefaultInjectionGraph();
    }

    public void testBuildAndApply() {
        // FIX BREADCRUMB 2328 reinstate when implemented
        try {
            subject.build();
            subject.apply(ctxMock);
            fail();
        } catch (UnsupportedOperationException expected) {}
    }
}
