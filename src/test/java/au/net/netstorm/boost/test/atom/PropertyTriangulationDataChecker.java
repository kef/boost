package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.util.exception.NotImplementedException;
import au.net.netstorm.boost.util.introspect.FieldSpec;

import java.lang.reflect.Constructor;

final class PropertyTriangulationDataChecker implements DataChecker {
    private FieldSpecTestUtil fieldSpecUtil = new DefaultFieldSpecTestUtil();
    private ReflectMaster reflectMaster = new DefaultReflectMaster();
    private TriangulationProvider triangulationProvider = new TestTriangulationProvider();
    private EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();

    public void check(Class cls, FieldSpec[] fields) {
        Object instance = createInstance(cls, fields);
    }

    private Object createInstance(Class cls, FieldSpec[] fields) {
        Object[] parameters = getInstances(fields);
        return getInstance(cls, parameters);
    }

    private void checkTriangulation(Class cls, FieldSpec field) {
        throw new NotImplementedException();
    }

    private Object getInstance(Class cls, Object[] parameters) {
        Constructor constructor = reflectMaster.getConstructor(cls);
        return getInstance(constructor, parameters);
    }

    private Object[] getInstances(FieldSpec[] fields) {
        Class[] classes = fieldSpecUtil.getTypes(fields);
        return triangulationProvider.getInstances(classes);
    }

    private Object getInstance(Constructor constructor, Object[] parameters) {
        constructor.setAccessible(true);
        return edgeConstructor.newInstance(constructor, parameters);
    }
}
