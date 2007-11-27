package au.net.netstorm.boost.util.impl;

import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultImplMaster implements ImplMaster {
    private final EdgeClass classer = new DefaultEdgeClass();
    private final ImplMapper[] mappers;

    public DefaultImplMaster(ImplMapper[] mappers) {
        this.mappers = mappers;
    }

    public <T, U extends T> Class<U> impl(Class<T> iface) {
        Interface<T> type = new DefaultInterface(iface);
        Implementation<U> implementation = impl(type);
        return implementation.getImpl();
    }

    public <T, U extends T> Implementation<U> impl(Interface<T> type) {
        // FIX 65590 Split.
        Implementation<U> impl = getImpl(type);
        if (impl == null) boom(type);
        return impl;
    }

    public boolean hasImpl(Interface<?> iface) {
        return getImpl(iface) != null;
    }

    private Implementation getImpl(Interface iface) {
        for (ImplMapper mapper : mappers) {
            Implementation impl = impl(mapper, iface);
            if (impl != null) return impl;
        }
        return null;
    }

    private Implementation impl(ImplMapper mapper, Interface iface) {
        if (!mapper.can(iface)) return null;
        return load(mapper, iface);
    }

    private Implementation load(ImplMapper mapper, Interface iface) {
        String name = mapper.map(iface);
        try {
            return load(name);
        } catch (EdgeException e) {
            return null;
        }
    }

    private Implementation load(String name) {
        Class impl = classer.forName(name);
        return new DefaultImplementation(impl);
    }

    private void boom(Interface type) {
        throw new NoImplementationException(type);
    }
}
