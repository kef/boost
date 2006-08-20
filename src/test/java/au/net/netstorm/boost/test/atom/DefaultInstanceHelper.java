package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.util.introspect.FieldSpec;

import java.lang.reflect.Constructor;

final class DefaultInstanceHelper implements InstanceHelper {
    private FieldSpecTestUtil fieldSpecUtil = new DefaultFieldSpecTestUtil();
    private TriangulationProvider triangulationProvider = new TestTriangulationProvider();
    private EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();
    private ReflectMaster reflectMaster = new DefaultReflectMaster();

    public Object getInstance(Class cls, Object[] parameters) {
        Constructor constructor = reflectMaster.getConstructor(cls);
        return getInstance(constructor, parameters);
    }

    public Object[] getInstances(FieldSpec[] fields) {
        Class[] classes = fieldSpecUtil.getTypes(fields);
        return triangulationProvider.getInstances(classes);
    }

    private Object getInstance(Constructor constructor, Object[] parameters) {
        constructor.setAccessible(true);
        return edgeConstructor.newInstance(constructor, parameters);
    }
}
