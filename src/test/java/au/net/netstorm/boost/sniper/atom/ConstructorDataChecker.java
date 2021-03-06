package au.net.netstorm.boost.sniper.atom;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.bullet.mirror.ClassMaster;
import au.net.netstorm.boost.bullet.mirror.DefaultClassMaster;
import au.net.netstorm.boost.bullet.mirror.DefaultReflectMaster;
import au.net.netstorm.boost.bullet.mirror.ReflectMaster;
import au.net.netstorm.boost.gunge.introspect.FieldSpec;
import au.net.netstorm.boost.sniper.field.DefaultFieldSpecTestUtil;
import au.net.netstorm.boost.sniper.field.FieldSpecTestUtil;
import junit.framework.Assert;

public final class ConstructorDataChecker implements DataChecker {
    private ReflectMaster reflectMaster = new DefaultReflectMaster();
    private ClassMaster classMaster = new DefaultClassMaster();
    private FieldSpecTestUtil fielder = new DefaultFieldSpecTestUtil();

    public void check(Class cls, FieldSpec[] fields) {
        checkSingleConstructor(cls);
        checkParametersMatch(cls, fields);
    }

    private void checkSingleConstructor(Class cls) {
        Constructor[] constructors = cls.getDeclaredConstructors();
        if (constructors.length == 1) return;
        fail(cls, "must have a single constructor which has a parameter for each property.");
    }

    private void checkParametersMatch(Class cls, FieldSpec[] fields) {
        Constructor constructor = reflectMaster.getConstructor(cls);
        Class[] declaredTypes = constructor.getParameterTypes();
        Class[] expectedTypes = fielder.getTypes(fields);
        checkConstructor(expectedTypes, declaredTypes);
    }

    private void checkConstructor(Class[] expectedTypes, Class[] declaredTypes) {
        checkParameterCount(expectedTypes, declaredTypes);
        checkParametersMatch(expectedTypes, declaredTypes);
    }

    private void checkParameterCount(Class[] expectedTypes, Class[] declaredTypes) {
        int expectedLength = expectedTypes.length;
        int declaredLength = declaredTypes.length;
        if (expectedLength == declaredLength) {
            return;
        }
        fail("Constructor must have " + expectedLength +
                " argument(s) matching the properties.  Instead it appears to have "
                + declaredLength + " arguments(s).");
    }

    private void checkParametersMatch(Class[] expected, Class[] declared) {
        for (int i = 0; i < expected.length; i++) {
            Class expectedCls = expected[i];
            Class declaredCls = declared[i];
            Assert.assertEquals("For constructor parameter " + i + " we", expectedCls, declaredCls);
        }
    }

    private void fail(Class cls, String msg) {
        String shortName = classMaster.getShortName(cls);
        fail(shortName + " " + msg);
    }

    private void fail(String msg) {
        Assert.fail(msg);
    }
}
