package au.net.netstorm.boost.test.fixture;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.util.introspect.FieldSpec;

final class DefaultInstanceTestUtil implements InstanceTestUtil {
    private final DefaultReflectMaster reflectMaster = new DefaultReflectMaster();
    private final TriangulationProviderTestUtil triangulationProviderTestUtil = new TriangulationProviderTestUtil();
    // FIX SC050 This is a smell.  Work out whether it can be removed.
    private static final TriangulationProvider EMPTY = new TestEmptyTriangulationProvider();

    public Object getInstance(Class cls, Object[] parameters) {
        Constructor constructor = getConstructor(cls);
        return triangulationProviderTestUtil.getInstance(constructor, parameters);
    }

    public Constructor getConstructor(Class cls) {
        return reflectMaster.getConstructor(cls);
    }

    public Object[] getInstances(FieldSpec[] fields) {
        Class[] classes = getClasses(fields);
        return triangulationProviderTestUtil.getInstances(classes, EMPTY); // FIX SC050 Smell ... EMPTY being here.
    }

    public Class[] getClasses(FieldSpec[] fields) {
        Class[] classes = new Class[fields.length];
        for (int i = 0; i < classes.length; i++) {
            classes[i] = fields[i].getType();
        }
        return classes;
    }
}
