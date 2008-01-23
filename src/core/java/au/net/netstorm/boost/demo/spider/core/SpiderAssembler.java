package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.spider.registry.Factories;
import au.net.netstorm.boost.spider.registry.Instances;

public interface SpiderAssembler {
    Spider assemble(Instances instances, Factories factories);
}
