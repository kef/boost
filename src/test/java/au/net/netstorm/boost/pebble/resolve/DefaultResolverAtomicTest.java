package au.net.netstorm.boost.pebble.resolve;

import au.net.netstorm.boost.pebble.core.PebbleProviderEngine;
import au.net.netstorm.boost.pebble.inject.resolver.core.ImplementationLookup;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

// FIX BREADCRUMB 1779 Stitch in to DefaultFieldResolver.
public final class DefaultResolverAtomicTest extends InteractionTestCase {
    private Resolver subject;
    private PebbleProviderEngine provider;
    private ImplementationLookup lookup;
    private Object jimInstance;
    private Object jackInstance;
    private Interface jim = iface(Jim.class);
    private Interface jack = iface(Jack.class);
    private Implementation jimImpl = impl(NoArgJim.class);
    private Implementation jackImpl = impl(OneArgJack.class);
    private Object[] noparams = {};

    public void setupSubjects() {
        subject = new DefaultResolver(provider, lookup);
    }

    // FIX BREADCRUMB 1779 Fix StringMaster.toString to flatten objects with a single field.
    public void testNoUnresolvedDependencies() {
        expect.oneCall(lookup, jimImpl, "find", jim);
        expect.oneCall(provider, jimInstance, "provide", jimImpl, noparams);
        Object result = subject.resolve(jim);
        assertEquals(jimInstance, result);
    }

    public void testOneUnresolvedDependencies() {
        expect.oneCall(lookup, jackImpl, "find", jack);
        expect.oneCall(lookup, jimImpl, "find", jim);
        expect.oneCall(provider, jimInstance, "provide", jimImpl, noparams);
        expect.oneCall(provider, jackInstance, "provide", jackImpl, new Object[]{jimInstance});
        Object result = subject.resolve(jack);
        assertEquals(jackInstance, result);
        // FIX 1779 Complete.
    }

    // FIX 1779 Multi-arg case.
    private Implementation impl(Class cls) {
        return new DefaultImplementation(cls);
    }

    private Interface iface(Class cls) {
        return new DefaultInterface(cls);
    }
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
