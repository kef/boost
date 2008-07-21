package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.gunge.collection.Creator;

public final class ParamertizedInstanceCreator implements Creator<InjectionSite, Object> {
    private final Provider provider;
    private final Object[] args;

    public ParamertizedInstanceCreator(Provider provider, Object[] args) {
        this.provider = provider;
        this.args = args;
    }

    public Object create(InjectionSite site) {
        return provider.nu(args);
    }
}
