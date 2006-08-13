package au.net.netstorm.boost.test.fixture;

import au.net.netstorm.boost.test.serialize.SerializationTestUtil;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.type.Data;

public final class DefaultDataTestChecker implements DataTestChecker {
    private InstanceTestUtil instancer = new DefaultInstanceTestUtil();

    public void checkIsData(Class cls, FieldSpec[] fields) {
        doCheckIsData(cls, fields);
    }

    public void checkIsData(Class cls, FieldSpec[] fields, TriangulationProvider additional) {
        doCheckIsData(cls, fields);
    }

    private void doCheckIsData(Class cls, FieldSpec[] fields) {
        // FIX SC050 Tidy this up.
        ClassTestFixture fixture = new ClassTestFixture(cls, fields);
        //
        // Checks is Data.class
        // Check extends Primordial.class
        // Checks constructor matches provided field specs.
        // Checks IAE is thrown if arguments are null.
        //
        fixture.checkClass(Data.class);
        Object[] parameters = instancer.getInstances(fields);
        Object instance = instancer.getInstance(cls, parameters);
        // Check if Serializable.
        SerializationTestUtil.checkSerializable(instance);
        MethodTestFixture.checkMethods(instance, fields);
        MemberTestFixture.checkMembers(instance, fields, parameters);
    }





    // FIX THE FOLLOWING CODE SAYS IT ALL (see FIXME)...

//    import au.net.netstorm.boost.test.fixture.DataTestChecker;
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
//            DataTestChecker.checkIsDataObject(RoadsideResponse.class, fields);
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
//            // FIX SC050 This passes (and should not!!!!!!!!!!!!!!!!!!!!!!!!!!).
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