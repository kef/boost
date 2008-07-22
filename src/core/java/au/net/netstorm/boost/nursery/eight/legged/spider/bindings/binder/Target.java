package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder;

import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public interface Target<T> {
    void to(T instance);

    void to(Class<? extends T> type);

    void to(Factory factory);

    void to(Provider provider);

    void toSingle(Class<? extends T> type);

    void toSingle(Factory factory);

    void toSingle(Provider provider);
}
