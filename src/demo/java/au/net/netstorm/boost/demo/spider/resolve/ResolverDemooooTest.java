package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.demo.spider.core.BoostSpiderBuilder;
import au.net.netstorm.boost.demo.spider.core.DefaultBoostSpiderBuilder;
import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.nursery.spider.onion.core.DefaultPeeler;
import au.net.netstorm.boost.nursery.spider.onion.core.Peeler;
import au.net.netstorm.boost.spider.core.DefaultGraphUtil;
import au.net.netstorm.boost.spider.core.GraphUtil;
import au.net.netstorm.boost.spider.instantiate.Nu;
import au.net.netstorm.boost.spider.registry.Registry;
import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

// Named "Demoooo" because we love "oooo"s.  Actually it does help us a lot.
public class ResolverDemooooTest extends InteractionTestCase {
    private final BoostSpiderBuilder spiderBuilder = new DefaultBoostSpiderBuilder();
    private final Spider spider = spiderBuilder.build();
    public final Peeler peeler = new DefaultPeeler();
    public final GraphUtil grapher = new DefaultGraphUtil();
    public final Registry registry = (Registry) spider.resolve(Registry.class);
    public final Resolver resolver = spider;
    public final Nu nu = spider;
}
