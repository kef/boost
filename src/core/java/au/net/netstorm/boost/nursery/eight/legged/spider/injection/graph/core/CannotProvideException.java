package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.bullet.primordial.PrimordialException;

// FIX 2394 merge/delete old CannotProvideException
public final class CannotProvideException extends PrimordialException {
    public CannotProvideException(InjectionSite site) {
        super("Cannot provide for site: " + site);
    }
}
