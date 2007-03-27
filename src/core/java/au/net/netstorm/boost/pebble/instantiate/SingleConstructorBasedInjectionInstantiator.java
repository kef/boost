package au.net.netstorm.boost.pebble.instantiate;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.util.type.Implementation;

public final class SingleConstructorBasedInjectionInstantiator implements Instantiator {
    private ReflectMaster reflectMaster = new DefaultReflectMaster();
    private EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();

    // FIX 32755 Return UnresolvedInstance?
    public Object instantiate(Implementation impl, Object[] parameters) {
        Class cls = impl.getImpl();
        Constructor constructor = reflectMaster.getConstructor(cls);
        constructor.setAccessible(true);
        return edgeConstructor.newInstance(constructor, parameters);
    }
}
