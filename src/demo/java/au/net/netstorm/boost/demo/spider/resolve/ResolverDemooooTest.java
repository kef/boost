package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.nursery.spider.core.BoostSpiderBuilder;
import au.net.netstorm.boost.nursery.spider.core.DefaultBoostSpiderBuilder;
import au.net.netstorm.boost.nursery.spider.onion.core.DefaultPeeler;
import au.net.netstorm.boost.nursery.spider.onion.core.Peeler;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.core.DefaultGraphUtil;
import au.net.netstorm.boost.spider.core.GraphUtil;
import au.net.netstorm.boost.spider.core.Spider;
import au.net.netstorm.boost.spider.instantiate.NuImpl;
import au.net.netstorm.boost.spider.registry.Registry;
import au.net.netstorm.boost.spider.resolve.Resolver;

// Named "Demoooo" because we love "oooo"s.  Actually it does help us a lot.
public class ResolverDemooooTest extends LifecycleTestCase implements LazyFields {
    private final Spider spider = nuSpider();
    public final Peeler peeler = new DefaultPeeler();
    public final GraphUtil grapher = new DefaultGraphUtil();
    public final Registry registry = spider.resolve(Registry.class);
    public final Resolver resolver = spider;
    public final NuImpl nuImpl = resolver.resolve(NuImpl.class);

    Spider nuSpider() {
        BoostSpiderBuilder spiderBuilder = new DefaultBoostSpiderBuilder();
        return spiderBuilder.build();
    }
}
