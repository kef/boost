package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.builder.DefaultSpiderEgg;
import au.net.netstorm.boost.nursery.eight.legged.spider.builder.SpiderEgg;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.spider.core.Spider;

public final class EightLeggedSpiderMolecularTest extends LifecycleTestCase implements InjectableTest {
    public void testSpider() {
        SpiderEgg egg = new DefaultSpiderEgg();
        Spider spider = egg.hatch();
        Foo foo = spider.nu(Foo.class);
        assertSame(DefaultFoo.class, foo.getClass());
    }
    // FIX 2394 circular dependencies
}
