package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.demo.spider.core.DefaultSpiderAssembler;
import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.demo.spider.core.SpiderAssembler;
import au.net.netstorm.boost.nursery.spider.onion.core.DefaultPeeler;
import au.net.netstorm.boost.nursery.spider.onion.core.Peeler;
import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.spider.core.DefaultGraphUtil;
import au.net.netstorm.boost.spider.core.GraphUtil;
import au.net.netstorm.boost.spider.flavour.DefaultFlavouredMap;
import au.net.netstorm.boost.spider.flavour.DefaultFlavouredMapEngine;
import au.net.netstorm.boost.spider.flavour.FlavouredMap;
import au.net.netstorm.boost.spider.flavour.FlavouredMapEngine;
import au.net.netstorm.boost.spider.registry.BlueprintMaster;
import au.net.netstorm.boost.spider.registry.DefaultRegistry;
import au.net.netstorm.boost.spider.registry.InstanceMaster;
import au.net.netstorm.boost.spider.registry.Registry;
import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.test.core.BoooostCase;

// Named "Demoooo" because we love "oooo"s.  Kidding right.  SO WE DON'T GET RUN AS A TEST :-)
public class ResolverDemooooTest extends BoooostCase {
    public final SpiderAssembler spiderAssembler = new DefaultSpiderAssembler();
    // FIX 2081 Move instance master and blueprint master construction into assembler.
    private FlavouredMapEngine instanceEngine = new DefaultFlavouredMapEngine();
    private FlavouredMap instanceFlavours = new DefaultFlavouredMap(instanceEngine);
    private final InstanceMaster instancer = new DefaultInstanceMaster(instanceFlavours);
    private FlavouredMapEngine blueprintEngine = new DefaultFlavouredMapEngine();
    private FlavouredMap blueprintFlavours = new DefaultFlavouredMap(blueprintEngine);
    private final BlueprintMaster blueprinter = new DefaultBlueprintMaster(blueprintFlavours);
    private final Spider spider = spiderAssembler.assemble(instancer, blueprinter);
    public final Peeler peeler = new DefaultPeeler();
    public final GraphUtil grapher = new DefaultGraphUtil();
    public final Registry registry = new DefaultRegistry(blueprinter, instancer);
    public final Resolver resolver = spider;
    public final Provider provider = spider;
}
