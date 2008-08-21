package au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.gunge.type.DefaultImplementation;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.ImplProvider;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

public final class ConcreteFactory implements Factory {
    public Provider nu(InjectionSite site) {
        if (!canHandle(site)) throw new IllegalArgumentException();
        Class cls = raw(site);
        Implementation impl = new DefaultImplementation(cls);
        return new ImplProvider(impl);
    }

    public boolean canHandle(InjectionSite site) {
        Class cls = raw(site);
        if (!isInstantiable(cls)) return false;
        // FIX 2394 this is not correct, there needs to be a common class for determining what is concrete
        return correctType(cls);
    }

    // FIX 2394 abstract these methods out.

    private boolean correctType(Class cls) {
        return !cls.isInterface() && !cls.isArray() && !cls.isAnnotation() && !cls.isEnum();
    }

    private boolean isInstantiable(Class<?> type) {
        Constructor[] ctors = type.getDeclaredConstructors();
        if (ctors.length != 1) return false;
        return canBeMadeAccessible(ctors[0]);
    }

    // FIX 2394 this is dodgy, work out how what security checks to perform rather than try/catch
    private boolean canBeMadeAccessible(Constructor ctor) {
        try {
            ctor.setAccessible(true);
            return true;
        } catch (SecurityException e) {
            return false;
        }
    }

    private Class raw(InjectionSite site) {
        InjectionType type = site.type();
        return type.rawClass();
    }
}
