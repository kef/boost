package au.net.netstorm.boost.nursery.spider.core;

import au.net.netstorm.boost.gunge.impl.DefaultImplMapper;
import au.net.netstorm.boost.gunge.impl.ImplMapper;
import au.net.netstorm.boost.gunge.impl.ImplMaster;
import au.net.netstorm.boost.nursery.gunge.impl.DefaultImplMaster;
import au.net.netstorm.boost.spider.builder.DefaultSpiderBuilder;
import au.net.netstorm.boost.spider.builder.Spider;
import au.net.netstorm.boost.spider.builder.SpiderBuilder;

public class DefaultBoostSpiderBuilder implements BoostSpiderBuilder {
    private final SpiderBuilder builder = new DefaultSpiderBuilder();

    public Spider build() {
        ImplMapper[] mappers = mappers();
        ImplMaster impler = new DefaultImplMaster(mappers);
        return builder.build(impler);
    }

    private ImplMapper[] mappers() {
        ImplMapper mapper = new DefaultImplMapper("Default");
        return new ImplMapper[]{mapper};
    }
}
