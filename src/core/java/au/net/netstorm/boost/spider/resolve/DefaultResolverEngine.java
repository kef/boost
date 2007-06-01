package au.net.netstorm.boost.spider.resolve;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.spider.inject.newer.assembly.NewerAssembler;
import au.net.netstorm.boost.spider.inject.newer.core.Newer;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.DefaultInterfaceUtil;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.InterfaceUtil;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultResolverEngine implements ResolverEngine {
    private static final Interface NEWER = new DefaultInterface(Newer.class);
    private final InterfaceUtil interfacer = new DefaultInterfaceUtil();
    private final ReflectMaster reflector = new DefaultReflectMaster();
    private final ProviderEngine provider;
    private final FinderEngine finder;
    private final NewerAssembler newerAssembler;

    // FIX BREADCRUMB 1977 HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH Split this.
    public DefaultResolverEngine(ProviderEngine provider, FinderEngine finder, NewerAssembler newerAssembler) {
        this.provider = provider;
        this.finder = finder;
        this.newerAssembler = newerAssembler;
    }

    public ResolvedInstance resolve(Interface iface, Flavour flavour) {
        if (hasInstance(iface, flavour)) return getInstance(iface, flavour);
        return getImplementation(iface, flavour);
    }

    public ResolvedInstance resolve(Implementation impl, Flavour flavour) {
        // FIX BREADCRUMB 1936 LLLLLLLLLLLLLLLLLLLLLLLLLLLLL parameters is always ZERO.  Remove dodgy code.
        Class[] parameters = getParameters(impl);
        Object[] resolvedParams = resolve(parameters, flavour);
        return provider.provide(impl, resolvedParams);
    }

    private Object[] resolve(Interface[] ifaces, Flavour flavour) {
        int length = ifaces.length;
        Object[] result = new Object[length];
        for (int i = 0; i < length; i++) {
            ResolvedInstance resolvedInstance = resolve(ifaces[i], flavour);
            result[i] = resolvedInstance.getRef();
        }
        return result;
    }

    private ResolvedInstance getImplementation(Interface iface, Flavour flavour) {
        Implementation impl = finder.getImplementation(iface, flavour);
        return resolve(impl, flavour);
    }

    private Object[] resolve(Class[] parameters, Flavour flavour) {
        Interface[] unresolved = interfacer.interfaces(parameters);
        return resolve(unresolved, flavour);
    }

    // SUGGEST: This really belongs in the pebble constructor area.  It is injection specific.
    private Class[] getParameters(Implementation impl) {
        Class cls = impl.getImpl();
        Constructor constructor = reflector.getConstructor(cls);
        return constructor.getParameterTypes();
    }

    private ResolvedInstance getInstance(Interface iface, Flavour flavour) {
        // FIX 1887 What about onionising the instance?
        if (iface.is(NEWER)) return aNewer(iface);
        return finder.getInstance(iface, flavour);
    }

    private boolean hasInstance(Interface iface, Flavour flavour) {
        if (iface.is(NEWER)) return true;
        return finder.hasInstance(iface, flavour);
    }

    private ResolvedInstance aNewer(Interface iface) {
        Newer newer = newerAssembler.assemble(iface);
        return new DefaultBaseReference(newer);
    }
}