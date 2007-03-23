package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultRegisterMaster implements RegisterMaster {
    private final Map implementationMap = new HashMap();
    private final Map instanceMap = new HashMap();

    public Implementation getImplementation(Interface iface) {
        Implementation implementation = (Implementation) implementationMap.get(iface);
        if (implementation == null) throw new UnresolvedDependencyException(iface);
        return implementation;
    }

    public boolean hasInstance(Interface iface) {
        return instanceMap.containsKey(iface);
    }

    public Instance getInstance(Interface iface) {
        Instance instance = (Instance) instanceMap.get(iface);
        if (instance == null) throw new UnresolvedDependencyException(iface);
        return instance;
    }

    public boolean hasImplementation(Interface iface) {
        return implementationMap.containsKey(iface);
    }

    public void prototype(Interface iface, Implementation implementation) {
        add(implementationMap, iface, implementation);
    }

    public void instance(Interface iface, Instance instance) {
        checkInstanceNotExists(iface);
        add(instanceMap, iface, instance);
    }

    private void checkInstanceNotExists(Interface iface) {
        if (hasInstance(iface)) throw new InstanceExistsException(iface);
    }

    private void add(Map map, Interface cls, Object value) {
        map.put(cls, value);
    }
}
