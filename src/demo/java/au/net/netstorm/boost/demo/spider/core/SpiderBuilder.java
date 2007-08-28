package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.util.impl.ImplMapper;

public interface SpiderBuilder {
    Spider build();

    Spider build(ImplMapper[] implMappers);
}