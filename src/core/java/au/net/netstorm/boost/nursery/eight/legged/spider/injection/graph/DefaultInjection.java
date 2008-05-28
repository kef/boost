package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.web.InjectionWeb;

// FIX 2394 this is a beast, maybe split into pre and post injection phases???
public final class DefaultInjection implements PhasedInjection {
    private final InjectionSite site;
    private final InjectionType type;
    private ConstructingInjection constructor;
    private MemberInjection members;

    public DefaultInjection(InjectionSite site) {
        this.site = site;
        this.type = site.type();
    }

    public void build(InjectionWeb web) {
        // FIX 2394 make these guys stateless factories
        constructor = new DefaultConstructingInjection(web, site, type);
        members = new DefaultMemberInjection(web, type);
    }

    public Object apply() {
        // FIX 2394 would this be simpler if there was a resolution queue rather than a graph
        Object ref = constructor.apply();
        members.apply(ref);
        return ref;
    }
}
