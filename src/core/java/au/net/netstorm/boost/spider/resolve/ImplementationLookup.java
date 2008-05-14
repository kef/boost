package au.net.netstorm.boost.spider.resolve;

public interface ImplementationLookup {
    <T> Class<? extends T> getImplementation(Class<T> iface);
}
