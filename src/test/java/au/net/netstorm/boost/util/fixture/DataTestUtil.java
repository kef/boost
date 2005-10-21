package au.net.netstorm.boost.util.fixture;


import au.net.netstorm.boost.util.type.Data;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.serialize.SerializationTestUtil;
import junit.framework.Assert;

// FIXME: SC501 Make instance.
public class DataTestUtil extends Assert {
    public static void checkIsDataObject(Class cls, FieldSpec[] newArgTypes) {
        ClassTestFixture.checkClass(cls, newArgTypes, Data.class);
        Object[] parameters = InstanceTestUtil.getParameters(newArgTypes);
        Object instance = InstanceTestUtil.getInstance(cls, parameters);
        SerializationTestUtil.checkSerializable(instance);
        MethodTestFixture.checkMethods(instance, newArgTypes);
        MemberTestFixture.checkMembers(instance, newArgTypes, parameters);
    }
}