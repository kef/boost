package au.net.netstorm.boost.util.fixture;

import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.serialize.SerializationTestUtil;
import au.net.netstorm.boost.util.type.Data;
import junit.framework.Assert;

// FIXME: SC506 Make instance.

public class DataTestUtil extends Assert {
    public static void checkIsDataObject(Class cls, FieldSpec[] fields) {
        doCheckIsData(cls, fields);
    }

    public static void checkIsDataObject(Class cls, FieldSpec[] fields, InstanceProvider additionalInstanceProvider) {
        checkIsDataObject(cls, fields);
    }

    private static void doCheckIsData(Class cls, FieldSpec[] fields) {
        ClassTestFixture.checkClass(cls, fields, Data.class);
        Object[] parameters = InstanceTestUtil.getParameters(fields);
        Object instance = InstanceTestUtil.getInstance(cls, parameters);
        SerializationTestUtil.checkSerializable(instance);
        MethodTestFixture.checkMethods(instance, fields);
        MemberTestFixture.checkMembers(instance, fields, parameters);
    }
}