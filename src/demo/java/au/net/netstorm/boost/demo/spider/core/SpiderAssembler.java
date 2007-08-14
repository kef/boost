package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.spider.registry.GreenPrints;
import au.net.netstorm.boost.spider.registry.Instances;

public interface SpiderAssembler {
    Spider assemble(GreenPrints greenprinter, Instances instancer);
}
