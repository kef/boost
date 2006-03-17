package au.net.netstorm.boost.test.fixture;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.util.introspect.FieldSpec;

public interface InstanceTestUtil {
    Object getInstance(Class cls, Object[] parameters);

    Constructor getConstructor(Class cls);

    Object[] getInstances(FieldSpec[] fields);

    Class[] getClasses(FieldSpec[] fields);
}
