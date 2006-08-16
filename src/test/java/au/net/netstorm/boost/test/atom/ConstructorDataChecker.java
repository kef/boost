package au.net.netstorm.boost.test.atom;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import junit.framework.Assert;

public final class ConstructorDataChecker implements DataChecker {
    private FieldSpecTestUtil fieldSpecUtil = new DefaultFieldSpecTestUtil();
    private ReflectMaster reflectMaster = new DefaultReflectMaster();

    public void check(Class cls, FieldSpec[] fields) {
        Constructor constructor = reflectMaster.getConstructor(cls);
        Class[] declaredTypes = constructor.getParameterTypes();
        Class[] expectedTypes = fieldSpecUtil.getTypes(fields);
        checkConstructor(expectedTypes, declaredTypes);
    }

    private void checkConstructor(Class[] expectedTypes, Class[] declaredTypes) {
        checkParameterCount(expectedTypes, declaredTypes);
        checkParametersMatch(expectedTypes, declaredTypes);
    }

    private void checkParameterCount(Class[] expectedTypes, Class[] declaredTypes) {
        int expectedLength = expectedTypes.length;
        int declaredLength = declaredTypes.length;
        if (expectedLength != declaredLength) Assert.fail("Constructor must have " + expectedLength + " argument(s).  Instead it appears to have "+declaredLength +" arguments(s).");
    }

    private void checkParametersMatch(Class[] expected, Class[] declared) {
        for (int i = 0; i < expected.length; i++) {
            Class expectedCls = expected[i];
            Class declaredCls = declared[i];
            Assert.assertEquals("For constructor parameter 0 we", expectedCls, declaredCls);
        }
    }
}
