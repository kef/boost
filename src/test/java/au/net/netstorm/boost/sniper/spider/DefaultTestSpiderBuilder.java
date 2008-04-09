package au.net.netstorm.boost.sniper.spider;

import au.net.netstorm.boost.demo.spider.core.DefaultSpiderBuilder;
import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.demo.spider.core.SpiderBuilder;
import au.net.netstorm.boost.nursery.util.impl.DefaultImplMaster;
import au.net.netstorm.boost.util.impl.DefaultImplMapper;
import au.net.netstorm.boost.util.impl.ImplMapper;
import au.net.netstorm.boost.util.impl.ImplMaster;

public class DefaultTestSpiderBuilder implements TestSpiderBuilder {
    public Spider build() {
        SpiderBuilder builder = new DefaultSpiderBuilder();
        ImplMaster master = getMapper();
        return builder.build(master);
    }

    private ImplMaster getMapper() {
        ImplMapper a1 = new DefaultImplMapper("Default");
        ImplMapper[] mappers = {a1};
        return new DefaultImplMaster(mappers);
    }
}
