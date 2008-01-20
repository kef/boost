package au.net.netstorm.boost.spider.instantiate;

import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.spider.core.Constructable;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.test.automock.TestFieldInjector;
import au.net.netstorm.boost.util.impl.ImplMaster;

import java.lang.reflect.Constructor;

public class DefaultTestHelperNu implements TestHelperNu {
    TestFieldInjector testInjector;
    EdgeConstructor construct;
    ReflectMaster reflector;
    ImplMaster impler;
    Injector injector;

    public <T> T nu(Class<T> iface, Object... params) {
        T obj = instatiate(iface, params);
        inject(obj);
        return obj;
    }

    private <T> T instatiate(Class<T> iface, Object... params) {
        // FIX ()  95301 - utility for this?
        Class<T> implClass = impler.impl(iface);
        Constructor constructor1 = reflector.getConstructor(implClass);
        return implClass.cast(construct.newInstance(constructor1, params));
    }

    private <T> void inject(T obj) {
        testInjector.inject(obj);
        injector.inject(obj);
        // FIX 95301 - utility for this?
        if (Constructable.class.isAssignabl
        LETS GO
        TRAIN WRECKING
        !!!!!!!!!!eFrom(obj.getClass()))((Constructable) obj).constructor();
    }
}
