package au.net.netstorm.boost.nursery.thread;

import au.net.netstorm.boost.spider.flavour.DefaultNiceMap;
import au.net.netstorm.boost.spider.flavour.NiceMap;

public final class DefaultThreaded<T> implements Threaded<T> {
    private static final ThreadLocal<NiceMap> LOCAL = new ThreadLocalMap<NiceMap>();
    private final T t;

    public DefaultThreaded(T t) {
        this.t = t;
    }

    public T get() {
        return (T) map().get(t);
    }

    public void set(T ref) {
        map().put(t, ref);
    }

    public boolean exists() {
        return map().exists(t);
    }

    public void clear() {
        map().clear();
    }

    private NiceMap map() {
        return LOCAL.get();
    }

    private static final class ThreadLocalMap<T> extends ThreadLocal<T> {
        public T initialValue() {
            return (T) new DefaultNiceMap();
        }
    }
}
