package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder;

import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

// FIX 2394 address multiplicity here instead of SingleMaker
// FIX 2394 or another idea is to do some name based injection, Binder single vs Binder multi and make it implicit

// FIX 2394 thinking about it, idea 2 is definately the way to go
public interface Target<T> {
    void to(T instance);

    void to(Class<? extends T> type);

    void to(Factory factory);

    void to(Provider provider);

    void toSingle(Class<? extends T> type);

    void toSingle(Factory factory);

    void toSingle(Provider provider);
}
