package au.net.netstorm.boost.spider.builder;

import au.net.netstorm.boost.nursery.spider.layer.Layers;
import au.net.netstorm.boost.spider.registry.Factories;
import au.net.netstorm.boost.spider.registry.Instances;
import au.net.netstorm.boost.spider.registry.Blueprints;

public interface SpiderAssembler {
    RegisteredSpider assemble(Instances instances, Factories factories, Blueprints blueprints, Layers proxies);
}
