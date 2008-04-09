package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.gunge.impl.ImplMaster;

public interface SpiderBuilder {
    Spider build(ImplMaster master);
}