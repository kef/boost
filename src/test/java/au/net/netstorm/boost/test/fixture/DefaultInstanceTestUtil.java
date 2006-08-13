package au.net.netstorm.boost.test.fixture;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.util.introspect.FieldSpec;

final class DefaultInstanceTestUtil implements InstanceTestUtil {
    private final DefaultReflectMaster reflectMaster = new DefaultReflectMaster();
    private final TriangulationProviderTestUtil triangulationProviderTestUtil = new TriangulationProviderTestUtil();
    private final TriangulationProvider triangulationProvider = new TestTriangulationProvider();

    public Object getInstance(Class cls, Object[] parameters) {
        Constructor constructor = getConstructor(cls);
        return triangulationProviderTestUtil.getInstance(constructor, parameters);
    }

    public Constructor getConstructor(Class cls) {
        return reflectMaster.getConstructor(cls);
    }

    public Object[] getInstances(FieldSpec[] fields) {
        Class[] classes = getClasses(fields);
        return triangulationProvider.getInstances(classes);
    }

    public Class[] getClasses(FieldSpec[] fields) {
        Class[] classes = new Class[fields.length];
        for (int i = 0; i < classes.length; i++) {
            classes[i] = fields[i].getType();
        }
        return classes;
    }
}
