package au.net.netstorm.boost.nursery.eight.legged.spider.factory.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.Binder;

public interface ConfigurableFactory extends Factory {
    void configure(Binder binder);
}
