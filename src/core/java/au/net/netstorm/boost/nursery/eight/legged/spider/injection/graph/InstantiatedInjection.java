package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.FieldInjectorFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.InjectorFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.MemberInjector;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.InjectionWeb;

public final class InstantiatedInjection implements Injection {
    private final InjectorFactory<MemberInjector> memberFactory = new FieldInjectorFactory();
    private final MemberInjector members;
    private final Object ref;

    public InstantiatedInjection(InjectionWeb web, InjectionSite site, Object ref) {
        this.members = memberFactory.nu(web, site);
        this.ref = ref;
    }

    public Object apply() {
        members.inject(ref);
        return ref;
    }
}
