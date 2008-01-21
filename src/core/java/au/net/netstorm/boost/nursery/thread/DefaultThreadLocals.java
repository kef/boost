package au.net.netstorm.boost.nursery.thread;

import au.net.netstorm.boost.spider.flavour.DefaultNiceMap;
import au.net.netstorm.boost.spider.flavour.NiceMap;

public final class DefaultThreadLocals implements ThreadLocals {
    private static final ThreadLocal<NiceMap> THREADED = new ThreadLocalMap<NiceMap>();

    public void clear() {
        get().clear();
    }

    public NiceMap get() {
        return THREADED.get();
    }

    private static final class ThreadLocalMap<T> extends ThreadLocal<T> {
        public T initialValue() {
            return (T) new DefaultNiceMap();
        }
    }
}
