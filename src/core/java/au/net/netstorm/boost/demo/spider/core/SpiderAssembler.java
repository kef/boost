package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.nursery.spider.layer.Layers;
import au.net.netstorm.boost.spider.register.Factories;
import au.net.netstorm.boost.spider.register.Instances;

public interface SpiderAssembler {
    Spider assemble(Instances instances, Factories factories, Layers proxies);
}
