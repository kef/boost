package au.net.netstorm.boost.test.fixture;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.util.introspect.FieldSpec;

// FIX SC600 What is this guy really?
public interface InstanceTestUtil {
    Object getInstance(Class cls, Object[] parameters);

    Object[] getInstances(FieldSpec[] fields);

    Constructor getConstructor(Class cls);

    Class[] getClasses(FieldSpec[] fields);
}
