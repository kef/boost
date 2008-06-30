package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder;

import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.ProviderFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.InstanceProvider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.ImplProvider;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.MutableBinding;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.DefaultImplementation;

public final class DefaultTarget implements Target {
    private final MutableBinding binding;

    public DefaultTarget(MutableBinding binding) {
        this.binding = binding;
    }

    public SingleMaker to(Object instance) {
        Provider p = new InstanceProvider(instance);
        return toProvider(p);
    }

    public SingleMaker to(Class<?> type) {
        Implementation impl = new DefaultImplementation(type);
        Provider p = new ImplProvider(impl);
        return toProvider(p);
    }

    public SingleMaker toProvider(Provider provider) {
        Factory f = new ProviderFactory(provider);
        return toFactory(f);
    }

    public SingleMaker toFactory(Factory factory) {
        binding.setFactory(factory);
        return new DefaultSingleMaker(binding);
    }

}
