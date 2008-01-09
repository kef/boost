package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.demo.spider.instance.DefaultPartialInstances;
import au.net.netstorm.boost.demo.spider.instance.PartialInstances;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.registry.Blueprint;
import au.net.netstorm.boost.spider.registry.Factories;
import au.net.netstorm.boost.spider.registry.Factory;
import au.net.netstorm.boost.spider.registry.Instances;
import au.net.netstorm.boost.spider.registry.Stamp;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

// FIX 2215 Some notes on the result of a spike...!!!!!!!!!!!!!!!!!!!!!!!!!!
// FIX ()   2237 Talk to PWL and extract relevant/good bits.

/*
   PWL 12 Nov, 07
   The spike was targeted at getting support for 'Proxy' implementations of an interface.
   Steps:
     - Introduce more 'Instance' references.  EG: RawInstance, InjectedInstance, ConstructedInstance, FinishedInstance
     - Introduce a 'Finisher' stage in spin-cycle: FinishedInstance finish(Interface iface, RawInstance inst)
     - Get Provider to use the new Finisher.
     - Figure out how to inject contextual Provider, Resolver, Finisher, Injector fields (others).
     - Add support for injection of 'Proxy' implementations.
       EG: Look for them specifically and inject the internal InvocationHandler.
     - Change factory interface to be: RawInstance get(Interface iface, Implementation host)
     - Provider is now just a convenience facility and Resolver should use the Finisher.

   NOTE: I reserve the right to change my mind at a moments notice.
*/
public final class DefaultResolverEngine implements ResolverEngine {
    private final PartialInstances inProgress = new DefaultPartialInstances();
    private final Instances instances;
    private final Factories factories;
    private final ProviderEngine provider;

    public DefaultResolverEngine(Instances instances, Factories factories, ProviderEngine provider) {
        this.instances = instances;
        this.factories = factories;
        this.provider = provider;
    }

    public synchronized ResolvedInstance resolve(Implementation host, Interface iface) {
        // FIX () BREADCRUMB   2237 BBBBBBBBBBBBBBB Move to after inProgress and use impl instead of iface.
        return get(host, iface);
    }

    private ResolvedInstance get(Implementation host, Interface iface) {
        Factory factory = factories.find(iface);
        Blueprint blueprint = factory.get(host, iface);
        return get(blueprint);
    }

    private ResolvedInstance get(Blueprint blueprint) {
        Implementation impl = blueprint.getImplementation();
        Object[] params = blueprint.getParameters();
        Stamp stamp = blueprint.getStamp();
        return get(impl, params, stamp);
    }

    private ResolvedInstance get(Implementation impl, Object[] params, Stamp stamp) {
        if (inProgress.exists(impl)) return inProgress.get(impl);
        if (instances.exists(impl)) return instances.get(impl);
        return manufacture(impl, params, stamp);
    }

    private ResolvedInstance manufacture(Implementation impl, Object[] params, Stamp stamp) {
        ResolvedInstance instance = provider.provide(impl, params);
        store(impl, instance, stamp);
        return instance;
    }

    private void store(Implementation impl, ResolvedInstance instance, Stamp stamp) {
        boolean isSingle = stamp.equals(Stamp.SINGLE);
        if (isSingle) instances.put(impl, instance);
    }
}