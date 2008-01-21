package au.net.netstorm.boost.nursery.thread;

import au.net.netstorm.boost.spider.flavour.DefaultNiceMap;
import au.net.netstorm.boost.spider.flavour.NiceMap;

public final class DefaultThreaded<T> implements Threaded<T> {
    private static final ThreadLocal<NiceMap> THREADED = new ThreadLocalMap<NiceMap>();
    private final Class type;

    public DefaultThreaded(Class<T> type) {
        this.type = type;
    }

    public T get() {
        return (T) map().get(type);
    }

    public void set(T ref) {
        map().put(type, ref);
    }

    public boolean exists() {
        return map().exists(type);
    }

    public void remove() {
        map().remove(type);
    }

    private NiceMap map() {
        return THREADED.get();
    }

    private static final class ThreadLocalMap<T> extends ThreadLocal<T> {
        public T initialValue() {
            return (T) new DefaultNiceMap();
        }
    }
}
