package au.net.netstorm.boost.test.atom;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;

final class DefaultInstanceHelper implements InstanceHelper {
    private EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();
    private ReflectMaster reflectMaster = new DefaultReflectMaster();

    public Object getInstance(Class cls, Object[] parameters) {
        Constructor constructor = reflectMaster.getConstructor(cls);
        return getInstance(constructor, parameters);
    }

    private Object getInstance(Constructor constructor, Object[] parameters) {
        constructor.setAccessible(true);
        return edgeConstructor.newInstance(constructor, parameters);
    }
}
