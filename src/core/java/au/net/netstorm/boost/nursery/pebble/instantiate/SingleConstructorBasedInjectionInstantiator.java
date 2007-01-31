package au.net.netstorm.boost.nursery.pebble.instantiate;

public final class SingleConstructorBasedInjectionInstantiator implements Instantiator {
    public Object instantiate(Class type, Object[] parameters) {
        return "Hi";
    }
}
