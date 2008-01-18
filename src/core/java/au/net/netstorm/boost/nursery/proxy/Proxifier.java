package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.spider.onion.core.Closure;

public interface Proxifier {
    // FIX 2248 Rename?
    <T> T closure(T ref, ProxySpec spec);

    <T> T closure(T ref, Class<? extends Closure>... closures);
}
