package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.spider.registry.Blueprints;
import au.net.netstorm.boost.spider.registry.Instances;

public interface SpiderAssembler {
    Spider assemble(Blueprints blueprinter, Instances instancer);
}
