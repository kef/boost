package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.spider.core.Provider;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.spider.resolve.SpiderWeb;

public interface Spider extends Provider, Injector, Resolver, SpiderWeb {
}
