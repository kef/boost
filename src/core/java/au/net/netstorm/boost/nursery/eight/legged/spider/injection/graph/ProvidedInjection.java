package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.FieldInjectorFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.InjectorFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.MemberInjector;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.InjectionWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public final class ProvidedInjection implements Injection {
    // FIX 2394 MAG Naming. Discuss.  I change memberFactory to members in some class somewhere.
    private final InjectorFactory<MemberInjector> memberFactory = new FieldInjectorFactory();
    private final MemberInjector members;
    private final Object[] args;
    private final Provider provider;

    public ProvidedInjection(InjectionWeb web, InjectionSite site, Provider provider, Object... args) {
        this.args = args;
        this.provider = provider;
        members = memberFactory.nu(web, site, provider);
    }

    public Object apply(InjectionContext context) {
        Object ref = provider.nu(args);
        members.inject(context, ref);
        return ref;
    }
}