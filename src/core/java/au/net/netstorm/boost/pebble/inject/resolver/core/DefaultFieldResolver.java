package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.pebble.core.PebbleProviderEngine;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultFieldResolver implements FieldResolver {
    private final ImplementationLookup lookup;
    private final PebbleProviderEngine provider;

    public DefaultFieldResolver(ImplementationLookup lookup, PebbleProviderEngine provider) {
        this.provider = provider;
        this.lookup = lookup;
    }

    public Object resolve(Field field) {
        Interface iface = getInterface(field);
        return resolve(iface);
    }

    // SUGGEST: This is probably the true resolver entry point and will likely take a "flavour".
    private Object resolve(Interface iface) {
        Implementation implementation = lookup.find(iface);
        return create(implementation);
    }

    // FIX BREADCRUMB 1779 Drive this out...
//    private Object[] resolveDependencies(Implementation implementation) {
//        List dependencyList = new ArrayList();
//        Class impl = implementation.getImpl();
//        // FIX 1779 use DefaultReflectMaster here.
//        Constructor constructor = impl.getDeclaredConstructors()[0];
//        Class[] dependencyTypes = constructor.getParameterTypes();
//        resolveEachDependency(dependencyTypes, dependencyList);
//        return dependencyList.toArray(new Object[]{});
//    }
//
//    private void resolveEachDependency(Class[] dependencyTypes, List dependencyList) {
//        for (int i = 0; i < dependencyTypes.length; i++) {
//            Class dependencyType = dependencyTypes[i];
//            DefaultInterface dependencyInterface = new DefaultInterface(dependencyType);
//            Object dependency = resolve(dependencyInterface);
//            dependencyList.add(dependency);
//        }
//    }

    private Object create(Implementation implementation) {
        Object[] dependencies = new Object[]{};
        return provider.provide(implementation, dependencies);
    }

    private Interface getInterface(Field field) {
        Class type = field.getType();
        return new DefaultInterface(type);
    }
}