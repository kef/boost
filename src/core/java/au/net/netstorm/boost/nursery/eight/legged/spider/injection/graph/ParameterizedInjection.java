package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.FieldInjectorFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.InjectorFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.MemberInjector;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.InjectionWeb;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;

public final class ParameterizedInjection implements Injection {
    private final InjectorFactory<MemberInjector> memberFactory = new FieldInjectorFactory();
    private MemberInjector members;
    private final Object[] args;
    private final Provider provider;

    public ParameterizedInjection(InjectionWeb web, InjectionSite site, Object[] args) {
        this.args = args;
        members = memberFactory.nu(web, site);
        provider = web.provider(site);
    }

    public Object apply() {
        Object ref = provider.nu(args);
        members.inject(ref);
        return ref;
    }
}
