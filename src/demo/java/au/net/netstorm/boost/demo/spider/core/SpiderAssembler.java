package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.spider.registry.Greenprints;
import au.net.netstorm.boost.spider.registry.Instances;

public interface SpiderAssembler {
    Spider assemble(Greenprints greenprints, Instances instances);
}
