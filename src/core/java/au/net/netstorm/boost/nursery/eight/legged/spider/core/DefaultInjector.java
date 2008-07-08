package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.Grapher;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.DefaultInjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionTypeBuilder;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.InjectableInstanceProvider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.spider.inject.core.Injector;

public final class DefaultInjector implements Injector {
    private final InjectionTypeBuilder typer = new DefaultInjectionTypeBuilder();
    private final Grapher grapher;

    public DefaultInjector(Grapher grapher) {
        this.grapher = grapher;
    }

    public void inject(Object ref) {
        Class<?> cls = ref.getClass();
        InjectionType type = typer.build(cls);
        Provider provider = new InjectableInstanceProvider(ref);
        grapher.graph(type, provider);
    }
}
