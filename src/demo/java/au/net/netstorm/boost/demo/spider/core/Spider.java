package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.spider.core.Provider;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.registry.Resolver;
import au.net.netstorm.boost.spider.resolve.Registry;

public interface Spider extends Provider, Injector, Resolver, Registry {
}
