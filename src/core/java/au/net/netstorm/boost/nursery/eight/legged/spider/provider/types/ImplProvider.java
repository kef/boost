package au.net.netstorm.boost.nursery.eight.legged.spider.provider.types;

import java.lang.reflect.Type;
import java.lang.reflect.Constructor;

import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.UnresolvedInstance;
import au.net.netstorm.boost.spider.instantiate.Instantiator;
import au.net.netstorm.boost.spider.instantiate.SingleConstructorBasedInjectionInstantiator;
import au.net.netstorm.boost.bullet.primordial.Primordial;

public final class ImplProvider extends Primordial implements Provider, HasParameters, HasInjectableTarget {
    // FIX 2394 should be pulled out
    private Instantiator instantiator = new SingleConstructorBasedInjectionInstantiator();
    // FIX 2394 Interface?
    // FIX 2394 can't be, not everything has an interface... maybe that could be changed,
    // FIX 2394 idea at the moment is that providers are not concerned with that resolution
    // FIX 2394 as they are more re-usable as really dumb instantiators
    // FIX 2394 all the smarts (and where new functionality gets plugged in) is in Factories
    private final Implementation impl;
    public ImplProvider(Implementation impl) {
        this.impl = impl;
    }

    public Object nu(Object... args) {
        UnresolvedInstance unresolved = instantiator.instantiate(impl, args);
        return unresolved.getRef();
    }

    // FIX 2394 probably should be a utility that does this
    public Type[] getParameterTypes() {
        Class<?> cls = impl.getImpl();
        Constructor<?>[] ctors = cls.getConstructors();
        if (ctors.length != 1) throw new IllegalArgumentException();
        Constructor<?> ctor = ctors[0];
        return ctor.getGenericParameterTypes();
    }

    public Class<?> getTargetClass() {
        return impl.getImpl();
    }
}
