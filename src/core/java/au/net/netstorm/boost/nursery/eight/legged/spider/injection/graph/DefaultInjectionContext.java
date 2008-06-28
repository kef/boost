package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.spider.flavour.StrictMap;
import au.net.netstorm.boost.spider.flavour.DefaultStrictMap;

public final class DefaultInjectionContext implements InjectionContext {
    private final StrictMap<Injection,Object> refs = new DefaultStrictMap<Injection, Object>();

    public boolean hasRef(Injection injection) {
        return refs.exists(injection);
    }

    public Object ref(Injection injection) {
        return refs.get(injection);
    }

    public void put(Injection injection, Object ref) {
        refs.put(injection, ref);
    }
}
