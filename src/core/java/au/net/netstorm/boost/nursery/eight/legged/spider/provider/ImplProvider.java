package au.net.netstorm.boost.nursery.eight.legged.spider.provider;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.UnresolvedInstance;
import au.net.netstorm.boost.spider.instantiate.Instantiator;
import au.net.netstorm.boost.spider.instantiate.SingleConstructorBasedInjectionInstantiator;

public final class ImplProvider extends Primordial implements Provider, HasParameters, HasInjectableTarget {
    private Instantiator instantiator = new SingleConstructorBasedInjectionInstantiator();
    private final Implementation impl;
    public ImplProvider(Implementation impl) {
        this.impl = impl;
    }

    public Object nu(Object... args) {
        UnresolvedInstance unresolved = instantiator.instantiate(impl, args);
        return unresolved.getRef();
    }

    // FIX 2394 should be a utility that does this
    // FIX 2394 MAG Damn right.  We'll move it out.
    public Type[] getParameterTypes() {
        Class<?> cls = impl.getImpl();
        Constructor<?>[] ctors = cls.getConstructors();
        if (ctors.length == 0) return new Type[0];
        if (ctors.length != 1) throw new IllegalArgumentException();
        Constructor<?> ctor = ctors[0];
        return ctor.getParameterTypes();
    }

    public Class<?> getTargetClass() {
        return impl.getImpl();
    }
}
