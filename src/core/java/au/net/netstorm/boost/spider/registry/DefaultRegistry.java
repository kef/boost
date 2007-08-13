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
    private static final Stamp MULTIPLE = Stamp.MULTIPLE;
    private static final Stamp SINGLE = Stamp.SINGLE;
    private final Instances instances;
    private final Blueprints blueprints;

    public DefaultRegistry(Blueprints blueprints, Instances instances) {
        this.blueprints = blueprints;
        this.instances = instances;
    }

    public void multiple(Class iface, Class impl) {
        blueprint(iface, UNFLAVOURED, impl, MULTIPLE);
    }

    public void single(Class iface, Class impl) {
        blueprint(iface, UNFLAVOURED, impl, SINGLE);
    }

    public void instance(Class iface, Object ref) {
        instance(iface, UNFLAVOURED, ref);
    }

    public void multiple(Class iface, Class impl, String flavour) {
        blueprint(iface, flavour, impl, MULTIPLE);
    }

    public void single(Class iface, Class impl, String flavour) {
        blueprint(iface, flavour, impl, SINGLE);
    }

    public void instance(Class iface, Object ref, String flavour) {
        instance(iface, flavour, ref);
    }

    private void blueprint(Class iface, String flavour, Class impl, Stamp stamp) {
        Flavour tasty = flavour(flavour);
        blueprint(iface, tasty, impl, stamp);
    }

    private void blueprint(Class iface, Flavour flavour, Class impl, Stamp stamp) {
        Interface inyerface = iface(iface);
        Implementation implementation = new DefaultImplementation(impl);
        Blueprint blueprint = new DefaultBlueprint(stamp, implementation, flavour);
        blueprints.put(inyerface, flavour, blueprint);
    }

    private void instance(Class iface, String flavour, Object ref) {
        Flavour tasty = flavour(flavour);
        instance(iface, tasty, ref);
    }

    private void instance(Class iface, Flavour flavour, Object ref) {
        Interface inyerface = iface(iface);
        ResolvedInstance instance = new DefaultBaseReference(ref);
        instances.put(inyerface, flavour, instance);
    }

    private Interface iface(Class iface) {
        return new DefaultInterface(iface);
    }

    private Flavour flavour(String flavour) {
        return new DefaultFlavour(flavour);
    }
}
