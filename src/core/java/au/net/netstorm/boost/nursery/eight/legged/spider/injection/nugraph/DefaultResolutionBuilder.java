package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.FieldInjectorFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.InjectorFactory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors.MemberInjector;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

// FIX 2394 use or lose. phase 2 of new Injections.
public final class DefaultResolutionBuilder implements ResolutionBuilder {
    private final InjectorFactory<MemberInjector> members = new FieldInjectorFactory();

    public void build(Injections injections, InjectionSite site) {
        throw new UnsupportedOperationException();
    }
}
