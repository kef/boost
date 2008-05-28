package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.ConstructorInjector;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.InjectorFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.ConstuctorInjectorFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.FieldInjectorFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.MemberInjector;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.InjectionWeb;

// FIX 2394 this is a beast, maybe split into pre and post injection phases???
public final class DefaultInjection implements PhasedInjection {
    // FIX 2394 these two injector factories should be passed in
    private final InjectorFactory<ConstructorInjector> ctorFactory = new ConstuctorInjectorFactory();
    private final InjectorFactory<MemberInjector> memberFactory = new FieldInjectorFactory();
    private final InjectionSite site;
    private ConstructorInjector constructor;
    private MemberInjector members;


    public DefaultInjection(InjectionSite site) {
        this.site = site;
    }

    public void build(InjectionWeb web) {
        constructor = ctorFactory.nu(web, site);
        members = memberFactory.nu(web, site);
    }

    public Object apply() {
        // FIX 2394 would this be simpler if there was a resolution queue rather than relying on underlying graph
        Object ref = constructor.inject();
        members.inject(ref);
        return ref;
    }
}
