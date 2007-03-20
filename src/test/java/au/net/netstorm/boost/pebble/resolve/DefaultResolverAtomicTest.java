package au.net.netstorm.boost.pebble.resolve;

import au.net.netstorm.boost.pebble.core.PebbleProviderEngine;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.Implementation;

// FIX BREADCRUMB 1779 Stitch in to DefaultFieldResolver.
public final class DefaultResolverAtomicTest extends InteractionTestCase {
    private Resolver subject;
    private PebbleProviderEngine provider;
    private Object ref;
    private Implementation noarg = new DefaultImplementation(NoArgJim.class);
    private Object[] noparams = {};

    public void setupSubjects() {
        subject = new DefaultResolver(provider);
    }

    // FIX BREADCRUMB 1779 In here and write.
    public void testNoUnresolvedDependencies() {
        expect.oneCall(provider, ref, "provide", noarg, noparams);
        Object result = subject.resolve(noarg);
        assertEquals(ref, result);
    }

    // FIX 1779 One arg.
    // FIX 1779 Multi-arg case.
}

// FIX 1779 Remove when done.
/*

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
        return resolve(implementation);
    }

//    private Object[] resolveDependencies(Implementation implementation) {
//        List dependencyList = new ArrayList();
//        Class impl = implementation.getImpl();
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

    private Object resolve(Implementation implementation) {
        Object[] dependencies = new Object[]{};
        return provider.provide(implementation, dependencies);
    }

    private Interface getInterface(Field field) {
        Class type = field.getType();
        return new DefaultInterface(type);
    }
}
*/
