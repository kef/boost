package au.net.netstorm.boost.util.fixture;

import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.serialize.SerializationTestUtil;
import au.net.netstorm.boost.util.type.Data;

public final class DefaultDataTestUtil implements DataTestUtil {
    private static final InstanceProvider EMPTY_PROVIDER = new TestEmptyInstanceProvider();
    private InstanceTestUtil instancer = new DefaultInstanceTestUtil();

    public void checkIsData(Class cls, FieldSpec[] fields) {
        doCheckIsData(cls, fields, EMPTY_PROVIDER);
    }

    public void checkIsData(Class cls, FieldSpec[] fields, InstanceProvider additional) {
        doCheckIsData(cls, fields, additional);
    }

    private void doCheckIsData(Class cls, FieldSpec[] fields, InstanceProvider additional) {
        // FIXME: SC050 Tidy this up.
        ClassTestFixture fixture = new ClassTestFixture(cls, fields);
        //
        // Checks is Data.class
        // Check extends Primordial.class
        // Checks constructor matches provided field specs.
        // Checks IAE is thrown if arguments are null.
        //
        fixture.checkClass(Data.class, additional);
        Object[] parameters = instancer.getInstances(fields);
        Object instance = instancer.getInstance(cls, parameters);
        SerializationTestUtil.checkSerializable(instance);
        MethodTestFixture.checkMethods(instance, fields);
        MemberTestFixture.checkMembers(instance, fields, parameters);
    }





    // FIXME: THE FOLLOWING CODE SAYS IT ALL (see FIXME)...
    
//    import au.net.netstorm.boost.util.fixture.DataTestUtil;
//    import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
//    import au.net.netstorm.boost.util.introspect.FieldSpec;
//    import junit.framework.TestCase;
//
//    public final class RoadsideResponseAtomicTest extends TestCase {
//        public static final RoadsideResponse INSTANCE_1 = buildResponse(1);
//        public static final RoadsideResponse INSTANCE_2 = buildResponse(2);
//
//        public void testData() {
//            FieldSpec f1 = new DefaultFieldSpec("httpStatus", int.class);
//            FieldSpec f2 = new DefaultFieldSpec("resultBytes", byte[].class);
//            FieldSpec[] fields = {f1, f2};
//            DataTestUtil.checkIsDataObject(RoadsideResponse.class, fields);
//        }
//
//        private static RoadsideResponse buildResponse(int i) {
//            String result = "result " + i;
//            byte[] bytes = result.getBytes();
//            return new RoadsideResponse(i, bytes);
//        }
//    }

//    import au.net.netstorm.boost.primordial.Primordial;
//    import au.net.netstorm.boost.util.type.Data;
//
//    public final class RoadsideResponse extends Primordial implements Data {
//        private final int httpStatus;
//        private final byte[] resultBytes;
//
//        public RoadsideResponse(int httpStatus, byte[] resultBytes) {
//            if (resultBytes == null) throw new IllegalArgumentException();
//            this.httpStatus = httpStatus;
//            this.resultBytes = resultBytes.clone();
//            // FIXME: SC050 This passes (and should not!!!!!!!!!!!!!!!!!!!!!!!!!!).
////        this.httpStatus = 2;
//        }
//
//        public int getHttpStatus() {
//            return httpStatus;
//        }
//
//        public byte[] getResultBytes() {
//            return resultBytes.clone();
//        }
//    }
}