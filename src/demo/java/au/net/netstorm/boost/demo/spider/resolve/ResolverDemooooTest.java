package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.demo.spider.core.DefaultSpiderAssembler;
import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.demo.spider.core.SpiderAssembler;
import au.net.netstorm.boost.spider.core.Provider;
import au.net.netstorm.boost.spider.flavour.DefaultFlavouredMap;
import au.net.netstorm.boost.spider.flavour.DefaultFlavouredMapEngine;
import au.net.netstorm.boost.spider.flavour.FlavouredMap;
import au.net.netstorm.boost.spider.flavour.FlavouredMapEngine;
import au.net.netstorm.boost.spider.registry.DefaultRegistry;
import au.net.netstorm.boost.spider.registry.DefaultRegistryMaster;
import au.net.netstorm.boost.spider.registry.Registry;
import au.net.netstorm.boost.spider.registry.RegistryMaster;
import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.test.core.BoooostCase;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;

// Named "Demoooo" because we love "oooo"s.  Kidding right.  SO WE DON'T GET RUN AS A TEST :-)
public class ResolverDemooooTest extends BoooostCase {
    public final SpiderAssembler spiderAssembler = new DefaultSpiderAssembler();
    private final FlavouredMapEngine engine = new DefaultFlavouredMapEngine();
    private final FlavouredMap web = new DefaultFlavouredMap(engine);
    private final RegistryMaster registryMaster = new DefaultRegistryMaster(web);
    private final Spider spider = spiderAssembler.assemble(registryMaster);
    public final FieldTestUtil fielder = new DefaultFieldTestUtil();
    public final Registry registry = new DefaultRegistry(registryMaster);
    public final Resolver resolver = spider;
    public final Provider provider = spider;
}
