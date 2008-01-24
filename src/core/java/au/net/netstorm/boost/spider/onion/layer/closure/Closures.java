package au.net.netstorm.boost.spider.onion.layer.closure;

import au.net.netstorm.boost.spider.onion.core.Layer;

public interface Closures {
    <T, U extends Layer> T closure(T ref, Class<U> cls, Object... args);
}
