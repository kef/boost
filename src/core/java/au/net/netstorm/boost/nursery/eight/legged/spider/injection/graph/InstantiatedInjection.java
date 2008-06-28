package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.FieldInjectorFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.InjectorFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.MemberInjector;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.InjectionWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.InstanceProvider;

public final class InstantiatedInjection implements Injection {
    private final InjectorFactory<MemberInjector> memberFactory = new FieldInjectorFactory();
    private final MemberInjector members;
    private final Object ref;

    public InstantiatedInjection(InjectionWeb web, InjectionSite site, Object ref) {
        // FIX 2394 smelly
        // FIX 2394 not sure if i even need the special case injections now that providers handle args
        Provider provider = new InstanceProvider(ref);
        this.members = memberFactory.nu(web, site, provider);
        this.ref = ref;
    }

    public Object apply(InjectionContext context) {
        members.inject(context, ref);
        return ref;
    }
}
