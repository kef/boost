package au.net.netstorm.boost.demo.nuspider.cycles;

import au.net.netstorm.boost.nursery.eight.legged.spider.builder.DefaultSpinneret;
import au.net.netstorm.boost.nursery.eight.legged.spider.builder.SpiderEgg;
import au.net.netstorm.boost.nursery.eight.legged.spider.builder.Spinneret;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.spider.core.Spider;

// FIX 2394 being used to drive through complex interaction testing, remove in favour of demo tests when possible
public final class EightLeggedSpiderMolecularTest extends LifecycleTestCase implements HasFixtures, InjectableTest {
    private Spider subject;

    public void setUpFixtures() {
        Spinneret spinneret = new DefaultSpinneret();
        SpiderEgg egg = spinneret.spin();
        subject = egg.hatch();
    }

    public void testSpider() {
        Foo foo = subject.nu(Foo.class);
        assertSame(DefaultFoo.class, foo.getClass());
    }

    public void testSpiderInject() {
        HasDependency target = new HasDependency();
        subject.inject(target);
        Foo foo = target.foo;
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
