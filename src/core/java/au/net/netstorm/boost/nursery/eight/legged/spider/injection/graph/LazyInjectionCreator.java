package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import java.util.Queue;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.collection.Creator;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class LazyInjectionCreator extends Primordial implements Creator<InjectionSite, Injection> {
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
