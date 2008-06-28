package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.builder.DefaultSpiderEgg;
import au.net.netstorm.boost.nursery.eight.legged.spider.builder.SpiderEgg;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.spider.core.Spider;

public final class EightLeggedSpiderMolecularTest extends LifecycleTestCase implements HasFixtures, InjectableTest {
    private Spider subject;

    public void setUpFixtures() {
        SpiderEgg egg = new DefaultSpiderEgg();
        subject = egg.hatch();
    }

    public void testSpider() {
        Foo foo = subject.nu(Foo.class);
        assertSame(DefaultFoo.class, foo.getClass());
    }

    public void testSpiderWithCyclicDependency() {
        Cyclic cyclic = subject.nu(Cyclic.class);
        assertSame(DefaultCyclic.class, cyclic.getClass());
        BackReference backReference = cyclic.get();
        assertSame(DefaultBackReference.class, backReference.getClass());
        Cyclic newCyclic = backReference.get();
        assertSame(DefaultCyclic.class, newCyclic.getClass());
    }
}
