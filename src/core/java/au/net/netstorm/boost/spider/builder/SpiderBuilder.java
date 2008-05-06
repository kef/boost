package au.net.netstorm.boost.spider.builder;

import au.net.netstorm.boost.gunge.impl.ImplMaster;

public interface SpiderBuilder {
    Spider build(ImplMaster master);
}