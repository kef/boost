package au.net.netstorm.boost.demo.spider.newer;

import au.net.netstorm.boost.demo.spider.core.DefaultSpiderAssembler;
import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.demo.spider.core.SpiderAssembler;
import au.net.netstorm.boost.spider.flavour.DefaultFlavouredMap;
import au.net.netstorm.boost.spider.flavour.DefaultFlavouredMapEngine;
import au.net.netstorm.boost.spider.flavour.FlavouredMap;
import au.net.netstorm.boost.spider.flavour.FlavouredMapEngine;
import au.net.netstorm.boost.spider.registry.DefaultRegistry;
import au.net.netstorm.boost.spider.registry.DefaultRegistryMaster;
import au.net.netstorm.boost.spider.registry.Registry;
import au.net.netstorm.boost.spider.registry.RegistryMaster;
import junit.framework.TestCase;

// FIX 1977 Extend ResolveTest (or SpiderTest)
public final class DefaultNewerDemoTest extends TestCase {
    private final FlavouredMapEngine engine = new DefaultFlavouredMapEngine();
    private final FlavouredMap web = new DefaultFlavouredMap(engine);
    private final RegistryMaster registryMaster = new DefaultRegistryMaster(web);
    private final SpiderAssembler assembler = new DefaultSpiderAssembler();
    private final Spider spider = assembler.assemble(registryMaster);
    public final Registry registry = new DefaultRegistry(registryMaster);

    public void testResolveNewer() {
        NewHeadJob newHeadJob = (NewHeadJob) spider.resolve(NewHeadJob.class);
        assertNotNull(newHeadJob);
        Job job = newHeadJob.nu();
        job.sayHi();
    }

    public void testRecursiveNewerInjection() {
        registry.multiple(Rob.class, DefaultRob.class);
        Rob rob = (Rob) spider.resolve(Rob.class);
        Bob bob = rob.getBob();
        checkNewersRecurse(bob);
    }

    private void checkNewersRecurse(Bob bob) {
        NewHeadJob newJobNewer = bob.getNewHeadJob();
        checkCreatedRecursively(newJobNewer);
    }

    private void checkCreatedRecursively(Object ref) {
        assertNotNull(ref);
    }
}

