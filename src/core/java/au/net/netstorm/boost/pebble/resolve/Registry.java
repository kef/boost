package au.net.netstorm.boost.pebble.resolve;

public interface Registry {
    void prototype(Class iface, Class impl);

    void instance(Class iface, Object ref);
}
