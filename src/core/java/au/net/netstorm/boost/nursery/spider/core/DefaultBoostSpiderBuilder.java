package au.net.netstorm.boost.nursery.spider.core;

import au.net.netstorm.boost.demo.spider.core.DefaultSpiderBuilder;
import au.net.netstorm.boost.demo.spider.core.Spider;
import au.net.netstorm.boost.demo.spider.core.SpiderBuilder;
import au.net.netstorm.boost.gunge.impl.DefaultImplMapper;
import au.net.netstorm.boost.gunge.impl.ImplMapper;
import au.net.netstorm.boost.gunge.impl.ImplMaster;
import au.net.netstorm.boost.nursery.util.impl.DefaultImplMaster;

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
