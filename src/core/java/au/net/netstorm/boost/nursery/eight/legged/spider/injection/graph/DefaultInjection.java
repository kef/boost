package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.ConstructorInjector;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.ConstuctorInjectorFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.FieldInjectorFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.InjectorFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.MemberInjector;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.state.InjectionWeb;

public final class DefaultInjection implements PhasedInjection {
    private final InjectorFactory<ConstructorInjector> ctorFactory = new ConstuctorInjectorFactory();
    private final InjectorFactory<MemberInjector> memberFactory = new FieldInjectorFactory();
    private final InjectionSite site;
    private ConstructorInjector constructor;
    private MemberInjector members;

    public DefaultInjection(InjectionSite site) {
        this.site = site;
    }

    public void build(InjectionWeb web) {
        // FIX 2394 would this be simpler if there was a resolution queue rather than relying on recursive graph?
        // FIX 2394 to implement the queue approach, InjectionWeb would be wrapped in LocalInjectionWeb which stores
        // FIX 2394 the injections just for this graph instance, this queue could than be processed twice: build, apply
        constructor = ctorFactory.nu(web, site);
        members = memberFactory.nu(web, site);
    }

    public Object apply() {
        Object ref = constructor.inject();
        members.inject(ref);
        return ref;
    }
}
