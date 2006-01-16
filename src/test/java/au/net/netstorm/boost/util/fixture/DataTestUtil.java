package au.net.netstorm.boost.util.fixture;

import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.serialize.SerializationTestUtil;
import au.net.netstorm.boost.util.type.Data;
import junit.framework.Assert;

// FIXME: SC506 Make instance.

public class DataTestUtil extends Assert {
    private static final InstanceProvider EMPTY_PROVIDER = new TestEmptyInstanceProvider();

    // FIXME: SC050 ? Rename to checkIsData.
    public static void checkIsDataObject(Class cls, FieldSpec[] fields) {
        doCheckIsData(cls, fields, EMPTY_PROVIDER);
    }

    public static void checkIsDataObject(Class cls, FieldSpec[] fields, InstanceProvider additional) {
        doCheckIsData(cls, fields, additional);
    }

    private static void doCheckIsData(Class cls, FieldSpec[] fields, InstanceProvider additional) {
        // FIXME: SC050 Tidy this up.
        ClassTestFixture fixture = new ClassTestFixture(cls, fields);
        fixture.checkClass(Data.class);
        Object[] parameters = InstanceTestUtil.getInstances(fields);
        Object instance = InstanceTestUtil.getInstance(cls, parameters);
        SerializationTestUtil.checkSerializable(instance);
        MethodTestFixture.checkMethods(instance, fields);
        MemberTestFixture.checkMembers(instance, fields, parameters);
    }
}