package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public interface Binding {
    Factory getFactory(InjectionSite site);
    boolean accepts(InjectionSite site);
    Precedence getPrecedence();
    InjectionType getType();
}
