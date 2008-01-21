package au.net.netstorm.boost.nursery.thread;

public interface Threaded<T> {
    T get();

    void set(T ref);

    boolean exists();

    void clear();
}
