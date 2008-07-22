package au.net.netstorm.boost.nursery.eight.legged.spider.provider;

import java.lang.reflect.Type;

import au.net.netstorm.boost.bullet.mirror.ConstructorMaster;
import au.net.netstorm.boost.bullet.mirror.DefaultConstructorMaster;
import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.UnresolvedInstance;
import au.net.netstorm.boost.spider.instantiate.Instantiator;
import au.net.netstorm.boost.spider.instantiate.SingleConstructorBasedInjectionInstantiator;

public final class ImplProvider extends Primordial implements Provider, HasParameters, HasInjectableTarget {
    private final ConstructorMaster master = new DefaultConstructorMaster();
    private final Instantiator instantiator = new SingleConstructorBasedInjectionInstantiator();
    private final Implementation impl;
    
    public ImplProvider(Implementation impl) {
        this.impl = impl;
    }

    public Object nu(Object... args) {
        UnresolvedInstance unresolved = instantiator.instantiate(impl, args);
        return unresolved.getRef();
    }

    public Type[] getParameterTypes() {
        return master.getGenericParameterTypes(impl);
    }

    public Class<?> getTargetClass() {
        return impl.getImpl();
    }
}
