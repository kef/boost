package au.net.netstorm.boost.pebble.type;

import java.util.Arrays;
import java.util.List;
import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultImplementation extends Primordial implements Implementation {
    Interface[] types;
    Class impl;

    public DefaultImplementation(Interface[] types, Class impl) {
        validate(types, impl);
        this.types = (Interface[]) types.clone();
        this.impl = impl;
        checkImplements();
    }

    public Interface[] getTypes() {
        return (Interface[]) types.clone();
    }

    public Class getImpl() {
        return impl;
    }

    private void checkImplements() {
        Class[] implInterfaces = impl.getInterfaces();
        List list = Arrays.asList(implInterfaces);
        int length = types.length;
        for (int i = 0; i < length; i++) {
            checkTypeIsImplemented(list, types[i]);
        }
    }

    private void checkTypeIsImplemented(List listOfImplementations, Interface type) {
        if (!listOfImplementations.contains(type.getType())) {
            String typeName = type.getType().getName();
            throw new IllegalArgumentException("The interface " + impl.getName() + " does not implement " + typeName);
        }
    }

    private void validate(Interface[] types, Class impl) {
        if (types == null) {
            throw new IllegalArgumentException();
        }
        if (impl == null) {
            throw new IllegalArgumentException();
        }
    }
}
