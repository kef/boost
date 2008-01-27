package au.net.netstorm.boost.nursery.thread;

import au.net.netstorm.boost.spider.flavour.DefaultStrictMap;
import au.net.netstorm.boost.spider.flavour.StrictMap;

public final class DefaultThreadLocals implements ThreadLocals {
    private static final ThreadLocal<StrictMap> THREADED = new ThreadLocalMap<StrictMap>();

    public void clear() {
        get().clear();
    }

    public StrictMap get() {
        return THREADED.get();
    }

    private static final class ThreadLocalMap<T> extends ThreadLocal<T> {
        public T initialValue() {
            return (T) new DefaultStrictMap();
        }
    }
}
