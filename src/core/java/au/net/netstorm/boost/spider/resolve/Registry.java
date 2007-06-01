package au.net.netstorm.boost.spider.resolve;

public interface Registry {
    void multiple(Class iface, Class impl);

    void instance(Class iface, Object ref);

    void multiple(Class iface, Class impl, String flavour);

    void instance(Class iface, Object ref, String flavour);
}
