package au.net.netstorm.boost.util.fixture;


import java.lang.reflect.Constructor;

import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.reflect.DefaultReflectMaster;

class InstanceTestUtil {
    static Object getInstance(Class cls, Object[] parameters) {
        return InstanceProviderTestUtil.getInstance(getConstructor(cls), parameters);
    }

    static Constructor getConstructor(Class cls) {
        return new DefaultReflectMaster().getConstructor(cls);
    }

    static Object[] getParameters(FieldSpec[] newArgTypes) {
        return InstanceProviderTestUtil.getInstances(getClasses(newArgTypes));
    }

    static Class[] getClasses(FieldSpec[] newArgTypes) {
        Class[] classes = new Class[newArgTypes.length];
        for (int i = 0; i < classes.length; i++) {
            classes[i] = newArgTypes[i].getType();
        }
        return classes;
    }
}
