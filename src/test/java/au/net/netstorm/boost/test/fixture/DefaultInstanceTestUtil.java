package au.net.netstorm.boost.test.fixture;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.util.introspect.FieldSpec;

// FIXME: SC502 Make instance.

final class DefaultInstanceTestUtil implements InstanceTestUtil {
    private static final DefaultReflectMaster REFLECT_MASTER = new DefaultReflectMaster();
    private static final TriangulationProviderTestUtil TRIANGULATION_PROVIDER_TEST_UTIL = new TriangulationProviderTestUtil();
    // FIXME: SC050 This is a smell.  Work out whether is can be removed.
    private static final TriangulationProvider EMPTY = new TestEmptyTriangulationProvider();

    public Object getInstance(Class cls, Object[] parameters) {
        Constructor constructor = getConstructor(cls);
        return TRIANGULATION_PROVIDER_TEST_UTIL.getInstance(constructor, parameters);
    }

    public Constructor getConstructor(Class cls) {
        return REFLECT_MASTER.getConstructor(cls);
    }

    public Object[] getInstances(FieldSpec[] fields) {
        Class[] classes = getClasses(fields);
        return TRIANGULATION_PROVIDER_TEST_UTIL.getInstances(classes, EMPTY); // FIXME: SC050 Smell ... EMPTY being here.
    }

    public Class[] getClasses(FieldSpec[] fields) {
        Class[] classes = new Class[fields.length];
        for (int i = 0; i < classes.length; i++) {
            classes[i] = fields[i].getType();
        }
        return classes;
    }
}
