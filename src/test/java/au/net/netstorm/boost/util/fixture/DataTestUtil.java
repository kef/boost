package au.net.netstorm.boost.util.fixture;

import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.serialize.SerializationTestUtil;
import au.net.netstorm.boost.util.type.Data;
import junit.framework.Assert;

// FIXME: SC506 Make instance.

public class DataTestUtil extends Assert {
    public static void checkIsDataObject(Class cls, FieldSpec[] newArgTypes) {
        ClassTestFixture.checkClass(cls, newArgTypes, Data.class);
        Object[] parameters = InstanceTestUtil.getParameters(newArgTypes);
        Object instance = InstanceTestUtil.getInstance(cls, parameters);
        SerializationTestUtil.checkSerializable(instance);
        MethodTestFixture.checkMethods(instance, newArgTypes);
        MemberTestFixture.checkMembers(instance, newArgTypes, parameters);
    }

    public static void checkIsDataObject(Class cls, FieldSpec[] fields, InstanceProvider customInstanceProvider) {
        checkIsDataObject(cls, fields);
    }
}