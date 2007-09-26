package au.net.netstorm.boost.spider.registry;

public interface Registry {
    void multiple(Class iface, Class impl);

    void single(Class iface, Class impl);

    void instance(Class iface, Object ref);

    void factory(Factory factory);

    void factory(Class cls);
}
