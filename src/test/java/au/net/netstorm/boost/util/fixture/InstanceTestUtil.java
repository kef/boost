package au.net.netstorm.boost.util.fixture;


import java.lang.reflect.Constructor;

import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.reflect.DefaultReflectMaster;

// FIXME: SC502 Make instance.
class InstanceTestUtil {
    private static final DefaultReflectMaster REFLECT_MASTER = new DefaultReflectMaster();
    private static final InstanceProviderTestUtil INSTANCE_PROVIDER_TEST_UTIL = new InstanceProviderTestUtil();

    static Object getInstance(Class cls, Object[] parameters) {
        Constructor constructor = getConstructor(cls);
        return INSTANCE_PROVIDER_TEST_UTIL.getInstance(constructor, parameters);
    }

    static Constructor getConstructor(Class cls) {
        return REFLECT_MASTER.getConstructor(cls);
    }

    static Object[] getInstances(FieldSpec[] fields) {
        Class[] classes = getClasses(fields);
        return INSTANCE_PROVIDER_TEST_UTIL.getInstances(classes);
    }

    static Class[] getClasses(FieldSpec[] fields) {
        Class[] classes = new Class[fields.length];
        for (int i = 0; i < classes.length; i++) {
            classes[i] = fields[i].getType();
        }
        return classes;
    }
}
