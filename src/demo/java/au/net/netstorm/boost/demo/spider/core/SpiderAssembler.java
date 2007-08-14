package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.spider.registry.GreenPrintsMonkey;
import au.net.netstorm.boost.spider.registry.Instances;

public interface SpiderAssembler {
    Spider assemble(GreenPrintsMonkey greenprinter, Instances instancer);
}
