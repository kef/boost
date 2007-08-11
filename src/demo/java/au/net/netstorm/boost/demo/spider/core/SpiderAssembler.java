package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.spider.registry.BlueprintMaster;
import au.net.netstorm.boost.spider.registry.InstanceMaster;

public interface SpiderAssembler {
    Spider assemble(InstanceMaster instancer, BlueprintMaster blueprinter);
}
