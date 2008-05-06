package au.net.netstorm.boost.spider.builder;

import au.net.netstorm.boost.nursery.spider.layer.Layers;
import au.net.netstorm.boost.spider.core.Spider;
import au.net.netstorm.boost.spider.registry.Factories;
import au.net.netstorm.boost.spider.registry.Instances;

public interface SpiderAssembler {
    Spider assemble(Instances instances, Factories factories, Layers proxies);
}
