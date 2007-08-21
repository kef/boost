package au.net.netstorm.boost.demo.spider.core;

import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.reflect.ClassMaster;
import au.net.netstorm.boost.reflect.DefaultClassMaster;
import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.spider.registry.Blueprint;
import au.net.netstorm.boost.spider.registry.DefaultBlueprint;
import au.net.netstorm.boost.spider.registry.Greenprints;
import au.net.netstorm.boost.spider.registry.Stamp;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class LazyGreenprints implements Greenprints {
    private static final Stamp SINGLE = Stamp.SINGLE;
    private static final Flavour UNFLAVOURED = Flavour.UNFLAVOURED;
    private final EdgeClass classer = new DefaultEdgeClass();
    private final ClassMaster master = new DefaultClassMaster();

    public Blueprint get(Interface iface, Flavour flavour) {
        String implName = impl(iface);
        return blueprint(implName);
    }

    public boolean exists(Interface iface, Flavour flavour) {
        String impl = impl(iface);
        return exists(impl);
    }

    private String impl(Interface iface) {
        String name = master.getShortName(iface);
        String pkg = master.getPackageName(iface);
        return pkg + "." + "Default" + name;
    }

    private Class get(String impl) {
        try {
            return classer.forName(impl);
        } catch (EdgeException e) {
            if (e.causeIs(ClassNotFoundException.class)) return null;
            throw e;
        }
    }

    private boolean exists(String impl) {
        Class result = get(impl);
        return result != null;
    }

    private Blueprint blueprint(String implName) {
        Class cls = get(implName);
        Implementation impl = new DefaultImplementation(cls);
        return new DefaultBlueprint(SINGLE, impl, UNFLAVOURED);
    }
}