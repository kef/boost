package au.net.netstorm.boost.pebble.type;

import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

// FIX 1715 Fail if an interface is passed in.
public final class DefaultImplementation extends Primordial implements Implementation {
    private final Interface[] types;
    private final Class impl;

    public DefaultImplementation(Class impl) {
        this.impl = impl;
        types = buildInterfaces();
    }

    public Interface[] getTypes() {
        return (Interface[]) types.clone();
    }

    public Class getImpl() {
        return impl;
    }

    private Interface[] buildInterfaces() {
        Class[] ifaces = impl.getInterfaces();
        List result = new ArrayList();
        for (int i = 0; i < ifaces.length; i++) {
            Interface iface = new DefaultInterface(ifaces[i]);
            result.add(iface);
        }
        return (Interface[]) result.toArray(new Interface[]{});
    }
}
