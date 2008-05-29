package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.ProviderFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.InstanceProvider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.ImplProvider;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.DefaultImplementation;

public final class DefaultMapping implements Mapping {
    private final RuleBuilder builder;

    public DefaultMapping(RuleBuilder builder) {
        this.builder = builder;
    }

    public Scope to(Object instance) {
        return to(new InstanceProvider(instance));
    }

    public MultiplicityOrScope to(Factory factory) {
        builder.setMapping(factory);
        return new DefaultMultiplicityOrScope(builder);
    }

    public MultiplicityOrScope to(Provider provider) {
        return to(new ProviderFactory(provider));
    }

    public MultiplicityOrScope to(Class<?> cls) {
        Implementation impl = new DefaultImplementation(cls);
        return to(new ImplProvider(impl));
    }
}
