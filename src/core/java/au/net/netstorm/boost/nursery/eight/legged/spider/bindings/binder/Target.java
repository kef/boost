package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder;

import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

// FIX 2394 address multiplicity here instead of SingleMaker
public interface Target {
    SingleMaker to(Object instance);
    SingleMaker to(Class<?> type);
    SingleMaker toFactory(Factory factory);
    SingleMaker toProvider(Provider provider);
}
