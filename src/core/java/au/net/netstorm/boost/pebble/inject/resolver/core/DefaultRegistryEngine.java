package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultRegistryEngine implements RegistryEngine {
    private final Map implementationMap = new HashMap();
    private final Map instanceMap = new HashMap();

    public Implementation getImplementation(Interface iface) {
        Class cls = (Class) implementationMap.get(iface);
        if (cls == null) throw new UnresolvedDependencyException(iface);
        return new DefaultImplementation(cls);
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

    public void prototype(Class iface, Class implementation) {
        add(implementationMap, iface, implementation);
    }

    public void instance(Class iface, Instance instance) {
        checkInstanceNotExists(iface);
        add(instanceMap, iface, instance);
    }

    private void checkInstanceNotExists(Class iface) {
        Interface inyerface = new DefaultInterface(iface);
        if (hasInstance(inyerface)) throw new InstanceExistsException(inyerface);
    }

    private void add(Map map, Class cls, Object value) {
        Interface inyerface = new DefaultInterface(cls);
        map.put(inyerface, value);
    }
}