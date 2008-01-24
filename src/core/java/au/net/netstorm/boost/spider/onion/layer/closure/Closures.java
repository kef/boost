package au.net.netstorm.boost.spider.onion.layer.closure;

import au.net.netstorm.boost.spider.onion.core.Layer;

public interface Closures {
    <T, U extends Layer> T closure(Class<U> cls, T ref, Object... args);
}
