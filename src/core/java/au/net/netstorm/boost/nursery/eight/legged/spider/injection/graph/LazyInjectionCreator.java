package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import java.util.Queue;

import au.net.netstorm.boost.nursery.eight.legged.spider.collections.Creator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class LazyInjectionCreator implements Creator<InjectionSite, Injection> {
    private final Queue<PhasedInjection> toBuild;

    public LazyInjectionCreator(Queue<PhasedInjection> toBuild) {
        this.toBuild = toBuild;
    }

    public Injection create(InjectionSite site) {
        PhasedInjection injection = new DefaultInjection(site);
        toBuild.offer(injection);
        return injection;
    }
}
