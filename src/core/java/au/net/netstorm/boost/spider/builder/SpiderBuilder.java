package au.net.netstorm.boost.spider.builder;

import au.net.netstorm.boost.gunge.impl.ImplMaster;
import au.net.netstorm.boost.spider.core.Spider;

public interface SpiderBuilder {
    Spider build(ImplMaster master);
}