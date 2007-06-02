package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.spider.core.Provider;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.registry.Registry;
import au.net.netstorm.boost.spider.xxx.Resolver;

public interface Spider extends Provider, Injector, Resolver, Registry {
}
