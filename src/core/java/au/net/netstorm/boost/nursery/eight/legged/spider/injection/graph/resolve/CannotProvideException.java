package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve;

import au.net.netstorm.boost.bullet.primordial.PrimordialException;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

// FIX 2394 merge/delete old CannotProvideException
public final class CannotProvideException extends PrimordialException {
    public CannotProvideException(InjectionSite site) {
        super("Cannot provide for site: " + site);
    }
}
