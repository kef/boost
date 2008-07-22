package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder;

import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.ProviderFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.SingletonFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.InstanceProvider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.ImplProvider;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.MutableBinding;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.DefaultImplementation;

public final class DefaultTarget<T> implements Target<T> {
    private final MutableBinding binding;

    public DefaultTarget(MutableBinding binding) {
        this.binding = binding;
    }

    public void to(T instance) {
        Provider p = new InstanceProvider(instance);
        to(p);
    }

    public void to(Class<? extends T> type) {
        Provider p = nuImpl(type);
        to(p);
    }

    public void to(Provider provider) {
        Factory f = new ProviderFactory(provider);
        to(f);
    }

    public void to(Factory factory) {
        binding.setFactory(factory);
    }

    public void toSingle(Class<? extends T> type) {
        Provider p = nuImpl(type);
        toSingle(p);
    }

    public void toSingle(Provider provider) {
        Factory f = new ProviderFactory(provider);
        toSingle(f);
    }

    public void toSingle(Factory factory) {
        Factory single = new SingletonFactory(factory);
        binding.setFactory(single);
    }

    private Provider nuImpl(Class<? extends T> type) {
        Implementation impl = new DefaultImplementation(type);
        return new ImplProvider(impl);
    }
}
