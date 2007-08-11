package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.DefaultFlavour;
import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultRegistry implements Registry {
    private static final Flavour UNFLAVOURED = Flavour.UNFLAVOURED;
    private final InstanceMaster instancer;
    private final BlueprintMaster blueprinter;

    public DefaultRegistry(BlueprintMaster blueprinter, InstanceMaster instancer) {
        this.instancer = instancer;
        this.blueprinter = blueprinter;
    }

    public void multiple(Class iface, Class impl) {
        multiple(iface, impl, UNFLAVOURED);
    }

    public void single(Class iface, Class impl) {
        // FIX 2081 Call single ON registry engine!!!
        multiple(iface, impl, UNFLAVOURED);
    }

    public void instance(Class iface, Object ref) {
        instance(iface, ref, UNFLAVOURED);
    }

    public void instance(Class iface, Object ref, String flavour) {
        Flavour tastyFlavour = flavour(flavour);
        instance(iface, ref, tastyFlavour);
    }

    public void multiple(Class iface, Class impl, String flavour) {
        Flavour tastyFlavour = flavour(flavour);
        multiple(iface, impl, tastyFlavour);
    }

    public void single(Class iface, Class impl, String flavour) {
        // FIX 2081 Call single ON registry engine!!!
        multiple(iface, impl, flavour);
    }

    private void multiple(Class iface, Class impl, Flavour tastyFlavour) {
        Interface inyerface = new DefaultInterface(iface);
        Implementation implementation = new DefaultImplementation(impl);
        Blueprint blueprint = new DefaultBlueprint(Stamp.MULTIPLE, implementation);
        blueprinter.blueprint(inyerface, blueprint, tastyFlavour);
    }

    private void instance(Class iface, Object ref, Flavour tastyFlavour) {
        Interface inyerface = new DefaultInterface(iface);
        ResolvedInstance instance = new DefaultBaseReference(ref);
        instancer.instance(inyerface, instance, tastyFlavour);
    }

    private Flavour flavour(String flavour) {
        return new DefaultFlavour(flavour);
    }
}
