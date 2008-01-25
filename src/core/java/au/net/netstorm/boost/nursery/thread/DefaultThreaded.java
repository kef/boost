package au.net.netstorm.boost.nursery.thread;

import au.net.netstorm.boost.spider.flavour.NiceMap;

public final class DefaultThreaded<T> implements Threaded<T> {
    private final ThreadLocals locals = new DefaultThreadLocals();
    private final Class type;

    public DefaultThreaded(Class<T> type) {
        this.type = type;
    }

    public T get() {
        return (T) map().get(type);
    }

    public void set(T ref) {
        // FIX ()   95450 This is a POWERFUL LINE.
        // FIX ()   95450 Remove and put in the IMPUTER (Stack of identities).
//        if (exists()) remove();
        map().put(type, ref);
    }

    public boolean exists() {
        return map().exists(type);
    }

    public void remove() {
        map().remove(type);
    }

    private NiceMap map() {
        return locals.get();
    }
}
