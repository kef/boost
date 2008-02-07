package au.net.netstorm.boost.nursery.thread;

import au.net.netstorm.boost.spider.flavour.StrictMap;

public final class DefaultThreaded<T> implements Threaded<T> {
    private final ThreadLocals locals = new DefaultThreadLocals();
    private final Class<T> type;

    public DefaultThreaded(Class<T> type) {
        this.type = type;
    }

    public T get() {
        Object ref = map().get(type);
        return type.cast(ref);
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

    private StrictMap map() {
        return locals.get();
    }
}
