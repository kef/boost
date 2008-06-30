package au.net.netstorm.boost.nursery.eight.legged.spider.injection.state;

import java.util.LinkedList;
import java.util.Queue;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.collection.Creator;
import au.net.netstorm.boost.gunge.collection.DefaultIntegrityMap;
import au.net.netstorm.boost.gunge.collection.IntegrityMap;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.Injection;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.LazyInjectionCreator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.LazyProviderCreator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.PhasedInjection;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;
import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.resolver.FactoryResolver;

public final class DefaultInjectionWeb extends Primordial implements InjectionWeb {
    // FIX 2394 need to address the behavior when a rule is updated
    private final IntegrityMap<InjectionSite, Provider> providers =
            new DefaultIntegrityMap<InjectionSite, Provider>();
    private final IntegrityMap<InjectionSite, Injection> injections =
            new DefaultIntegrityMap<InjectionSite, Injection>();

    private final FactoryResolver resolver;

    public DefaultInjectionWeb(FactoryResolver resolver) {
        this.resolver = resolver;
    }

    public Provider provider(InjectionSite site) {
        Creator<InjectionSite, Provider> creator = new LazyProviderCreator(resolver);
        return providers.getOrCreate(site, creator);
    }

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