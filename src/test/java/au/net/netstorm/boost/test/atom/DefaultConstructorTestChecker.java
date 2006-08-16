package au.net.netstorm.boost.test.atom;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import junit.framework.Assert;

public final class DefaultConstructorTestChecker implements ConstructorTestChecker {
    private FieldSpecTestUtil fieldSpecUtil = new DefaultFieldSpecTestUtil();
    private ReflectMaster reflectMaster = new DefaultReflectMaster();

    public void checkMatches(Class cls, FieldSpec[] fields) {
        Constructor constructor = reflectMaster.getConstructor(cls);
        Class[] declaredTypes = constructor.getParameterTypes();
        Class[] expectedTypes = fieldSpecUtil.getTypes(fields);
        checkConstructor(expectedTypes, declaredTypes);
    }


    private void checkConstructor(Class[] expectedTypes, Class[] declaredTypes) {
        int expectedLength = expectedTypes.length;
        int declaredLength = declaredTypes.length;
        if (expectedLength != declaredLength) Assert.fail("Constructor must have " + expectedLength + " argument(s).  Instead it appears to have "+declaredLength +" arguments(s).");
        // FIX SC600 BREADCRUMB Continue this.
        // Checks constructor parameters match provided field specs.
    }
}
