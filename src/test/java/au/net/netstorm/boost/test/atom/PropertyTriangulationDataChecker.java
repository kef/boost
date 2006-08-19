package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.test.reflect.util.DefaultMethodTestUtil;
import au.net.netstorm.boost.test.reflect.util.MethodTestUtil;
import au.net.netstorm.boost.util.introspect.FieldSpec;

import java.lang.reflect.Constructor;

final class PropertyTriangulationDataChecker implements DataChecker {
    private static final Object[] NO_ARGUMENTS = null;
    private FieldSpecTestUtil fieldSpecUtil = new DefaultFieldSpecTestUtil();
    private PropertyNameProvider nameProvider = new DefaultPropertyNameProvider();
    private TriangulationProvider triangulationProvider = new TestTriangulationProvider();
    private EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();
    private MethodTestUtil methodUtil = new DefaultMethodTestUtil();
    private ReflectMaster reflectMaster = new DefaultReflectMaster();
    private EdgeClass edgeClass = new DefaultEdgeClass();

    public void check(Class cls, FieldSpec[] fields) {
        Object[] values = getInstances(fields);
        Object instance = createInstanceWithValues(cls, values);
        checkPropertyValuesMatch(instance, fields, values);
    }

    private Object createInstanceWithValues(Class cls, Object[] values) {
        return getInstance(cls, values);
    }

    private void checkPropertyValuesMatch(Object instance, FieldSpec[] fields, Object[] parameters) {
        for (int i = 0; i < fields.length; i++) {
            Object parameter = parameters[i];
            FieldSpec field = fields[i];
            checkPropertyValueMatches(instance, field, parameter);
        }
    }

    private void checkPropertyValueMatches(Object instance, FieldSpec field, Object parameter) {
        String methodName = nameProvider.getPropertyMethodName(field);
        invoke(instance, methodName);
    }

    private void invoke(Object instance, String methodName) {
        methodUtil.invoke(instance, methodName, NO_ARGUMENTS);
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
