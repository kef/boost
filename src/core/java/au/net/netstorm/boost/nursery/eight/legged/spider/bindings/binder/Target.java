package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder;

import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

// FIX 2394 address multiplicity here instead of SingleMaker
// FIX 2394 or another idea is to do some name based injection, Binder single vs Binder multi and make it implicit
// FIX 2394 thinking about it, idea 2 is definately the way to go
public interface Target<T> {
    SingleMaker to(T instance);
    SingleMaker to(Class<? extends T> type);
    SingleMaker toFactory(Factory factory);
    SingleMaker toProvider(Provider provider);
}
