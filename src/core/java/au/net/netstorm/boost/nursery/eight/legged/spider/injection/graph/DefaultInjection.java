package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.ConstructorInjector;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.InjectorFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.ConstuctorInjectorFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.InjectionWeb;

// FIX 2394 this is a beast, maybe split into pre and post injection phases???
public final class DefaultInjection implements PhasedInjection {
    // FIX 2394 these two injector factories should be passed in
    private final InjectorFactory<ConstructorInjector> ctorFactory = new ConstuctorInjectorFactory();
//    private final InjectorFactory<MemberInjection> memberFactory = new FieldInjectorFactory();
    private final InjectionSite site;
    // FIX 2394 dissapear this field;
    private final InjectionType type;
    private ConstructorInjector constructor;
    private MemberInjection members;


    public DefaultInjection(InjectionSite site) {
        this.site = site;
        this.type = site.type();
    }

    public void build(InjectionWeb web) {
        // FIX 2394 make these guys stateless factories
        constructor = ctorFactory.nu(web, site);
        members = new DefaultMemberInjection(web, type);
    }

    public Object apply() {
        // FIX 2394 would this be simpler if there was a resolution queue rather than a graph
        Object ref = constructor.inject();
        members.apply(ref);
        return ref;
    }
}
