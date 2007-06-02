package au.net.netstorm.boost.spider.registry;

public interface Registry {
    void multiple(Class iface, Class impl);

    void instance(Class iface, Object ref);

    void multiple(Class iface, Class impl, String flavour);

    void instance(Class iface, Object ref, String flavour);
}
