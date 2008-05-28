package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import java.util.Queue;
import java.util.LinkedList;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.collections.IntegrityMap;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.collections.DefaultIntegrityMap;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.collections.Creator;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.types.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.resolver.RuleResolver;

public final class DefaultInjectionContext implements InjectionContext {
    private final IntegrityMap<InjectionSite, Provider> providers =
            new DefaultIntegrityMap<InjectionSite, Provider>();
    private final IntegrityMap<InjectionSite, Injection> injections =
            new DefaultIntegrityMap<InjectionSite, Injection>();
    private final RuleResolver resolver;

    public DefaultInjectionContext(RuleResolver resolver) {
        this.resolver = resolver;
    }

    public Provider provider(InjectionSite site) {
        Creator<InjectionSite, Provider> creator = new LazyProviderCreator(resolver);
        return providers.getOrCreate(site, creator);
    }

    // FIX 2394 build phase could be delayed even more by pushing it up a layer
    public Injection injection(InjectionSite site) {
        // FIX 2394 nasty hack alert
        Queue<PhasedInjection> toBuild = new LinkedList<PhasedInjection>();
        Creator<InjectionSite, Injection> creator = new LazyInjectionCreator(toBuild);
        Injection injection = injections.getOrCreate(site, creator);
        buildInjections(toBuild);
        return injection;
    }

    private void buildInjections(Queue<PhasedInjection> tobuild) {
        while (tobuild.size() > 0) {
            PhasedInjection phase = tobuild.remove();
            phase.build(this);
        }
    }
}
