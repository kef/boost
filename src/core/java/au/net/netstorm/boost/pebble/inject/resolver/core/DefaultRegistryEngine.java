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

    public Implementation getImplementation(Interface type) {
        Class cls = (Class) implementationMap.get(type);
        if (cls == null) throw new UnresolvedDependencyException(type);
        return new DefaultImplementation(cls);
    }

    public Instance getInstance(Interface iface) {
        return (Instance) instanceMap.get(iface);
    }

    public void prototype(Class iface, Class implementation) {
        add(implementationMap, iface, implementation);
    }

    public void instance(Class iface, Instance instance) {
        add(instanceMap, iface, instance);
    }

    private void add(Map map, Class cls, Object value) {
        Interface inyerface = new DefaultInterface(cls);
        map.put(inyerface, value);
    }
}
