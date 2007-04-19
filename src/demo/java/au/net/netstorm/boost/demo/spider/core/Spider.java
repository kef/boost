package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.spider.core.Provider;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.resolve.Registry;
import au.net.netstorm.boost.spider.resolve.ResolverEngine;

// FIX BREADCRUMB 1914 -AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA The resolver engine should be a resolver.
public interface Spider extends Provider, Injector, ResolverEngine, Registry {
}
