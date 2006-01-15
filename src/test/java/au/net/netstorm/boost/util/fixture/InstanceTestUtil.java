package au.net.netstorm.boost.util.fixture;


import java.lang.reflect.Constructor;

import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.reflect.DefaultReflectMaster;

// FIXME: SC502 Make instance.
class InstanceTestUtil {
    private static final DefaultReflectMaster REFLECT_MASTER = new DefaultReflectMaster();
    private static final InstanceProviderTestUtil INSTANCE_PROVIDER_TEST_UTIL = new InstanceProviderTestUtil();

    static Object getInstance(Class cls, Object[] parameters) {
        return INSTANCE_PROVIDER_TEST_UTIL.getInstance(getConstructor(cls), parameters);
    }

    static Constructor getConstructor(Class cls) {
        return REFLECT_MASTER.getConstructor(cls);
    }

    static Object[] getParameters(FieldSpec[] newArgTypes) {
        return INSTANCE_PROVIDER_TEST_UTIL.getInstances(getClasses(newArgTypes));
    }

    static Class[] getClasses(FieldSpec[] newArgTypes) {
        Class[] classes = new Class[newArgTypes.length];
        for (int i = 0; i < classes.length; i++) {
            classes[i] = newArgTypes[i].getType();
        }
        return classes;
    }
}
