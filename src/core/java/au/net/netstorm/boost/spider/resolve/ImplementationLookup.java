package au.net.netstorm.boost.spider.resolve;

// FIX 2328 this smells bad, needs to be factory abstraction, see FIXes on Factory interface
public interface ImplementationLookup {
    <T> Class<? extends T> getImplementation(Class<T> iface);
}
