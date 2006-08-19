package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeMethod;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeMethod;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.util.introspect.FieldSpec;

import java.lang.reflect.Constructor;

final class PropertyTriangulationDataChecker implements DataChecker {
    private FieldSpecTestUtil fieldSpecUtil = new DefaultFieldSpecTestUtil();
    private PropertyNameProvider nameProvider = new DefaultPropertyNameProvider();
    private TriangulationProvider triangulationProvider = new TestTriangulationProvider();
    private EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();
    private ReflectMaster reflectMaster = new DefaultReflectMaster();
    private EdgeMethod edgeMethod = new DefaultEdgeMethod();

    public void check(Class cls, FieldSpec[] fields) {
        Object[] parameters = getInstances(fields);
        Object instance = getInstance(cls, parameters);
        checkPropertiesMatchParameters(instance, fields, parameters);
    }

    private void checkPropertiesMatchParameters(Object instance, FieldSpec[] fields, Object[] parameters) {
        for (int i = 0; i < fields.length; i++) {
            Object parameter = parameters[i];
//            checkPropertyMatchesParameter(instance, field, parameter);
        }
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
