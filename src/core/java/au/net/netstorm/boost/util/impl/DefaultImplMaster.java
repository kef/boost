package au.net.netstorm.boost.util.impl;

import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultImplMaster implements ImplMaster {
    private EdgeClass classer = new DefaultEdgeClass();
    private ImplMapper mapper = new BasicImplMapper();

    public Implementation impl(Interface iface) {
        String name = defaultImplName(iface);
        Class impl = classer.forName(name);
        return new DefaultImplementation(impl);
    }

    public boolean hasImpl(Interface iface) {
        try {
            impl(iface);
            return true;
        } catch (EdgeException e) {
            return false;
        }
    }

    private String defaultImplName(Interface iface) {
        return mapper.map(iface);
    }
}
