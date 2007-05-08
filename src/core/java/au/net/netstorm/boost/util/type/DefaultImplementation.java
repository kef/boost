package au.net.netstorm.boost.util.type;

import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.primordial.Primordial;

public final class DefaultImplementation extends Primordial implements Implementation {
    private final Interface[] types;
    private final Class impl;

    public DefaultImplementation(Class impl) {
        this.impl = impl;
        types = buildInterfaces();
        validate();
    }

    public Interface[] getTypes() {
        return (Interface[]) types.clone();
    }

    public Class getImpl() {
        return impl;
    }

    public boolean is(Interface iface) {
        for (int i = 0; i < types.length; i++) {
            Interface type = types[i];
            if (type.is(iface)) return true;
        }
        return false;
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

    private void validate() {
        if (impl.isInterface()) {
            String failMessage = impl + " should be an implementation and not an interface.";
            throw new IllegalArgumentException(failMessage);
        }
    }
}
