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
import au.net.netstorm.boost.spider.registry.Blueprints;
import au.net.netstorm.boost.spider.registry.DefaultBlueprints;
import au.net.netstorm.boost.spider.registry.DefaultInstances;
import au.net.netstorm.boost.spider.registry.DefaultRegistry;
import au.net.netstorm.boost.spider.registry.Instances;
import au.net.netstorm.boost.spider.registry.Registry;
import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.test.core.BoooostCase;

// SUGGEST: Move instances and blueprints construction into assemblers.

// Named "Demoooo" because we love "oooo"s.  Actually it does help us a lot.
public class ResolverDemooooTest extends BoooostCase {
    private final FlavouredMapEngine instanceEngine = new DefaultFlavouredMapEngine();
    private final FlavouredMap instanceFlavours = new DefaultFlavouredMap(instanceEngine);
    private final Instances instances = new DefaultInstances(instanceFlavours);
    private final FlavouredMapEngine blueprintEngine = new DefaultFlavouredMapEngine();
    private final FlavouredMap blueprintFlavours = new DefaultFlavouredMap(blueprintEngine);
    private final Blueprints blueprints = new DefaultBlueprints(blueprintFlavours);
    // FIX 1887 Use the spider builder, not the assembler.
    private final SpiderAssembler spiderAssembler = new DefaultSpiderAssembler();
    private final Spider spider = spiderAssembler.assemble(blueprints, instances);
    public final Peeler peeler = new DefaultPeeler();
    public final GraphUtil grapher = new DefaultGraphUtil();
    public final Registry registry = new DefaultRegistry(blueprints, instances);
    public final Resolver resolver = spider;
    public final Provider provider = spider;
}
