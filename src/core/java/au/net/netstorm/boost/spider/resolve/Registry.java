package au.net.netstorm.boost.spider.resolve;

public interface Registry {
    void prototype(Class iface, Class impl);

    void instance(Class iface, Object ref);
}
