package au.net.netstorm.boost.sniper.spider;

import au.net.netstorm.boost.gunge.impl.DefaultImplMapper;
import au.net.netstorm.boost.gunge.impl.ImplMapper;
import au.net.netstorm.boost.gunge.impl.ImplMaster;
import au.net.netstorm.boost.nursery.gunge.impl.DefaultImplMaster;
import au.net.netstorm.boost.spider.builder.DefaultSpiderBuilder;
import au.net.netstorm.boost.spider.builder.Spider;
import au.net.netstorm.boost.spider.builder.SpiderBuilder;

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
