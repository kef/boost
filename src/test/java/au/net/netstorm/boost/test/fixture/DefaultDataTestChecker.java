package au.net.netstorm.boost.test.fixture;

import au.net.netstorm.boost.test.serialize.SerializationTestUtil;
import au.net.netstorm.boost.test.checker.ClassTestChecker;
import au.net.netstorm.boost.test.checker.DefaultClassTestChecker;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.type.Data;
import au.net.netstorm.boost.primordial.Primordial;

// FIX SC600 Rename FieldSpec to NamedType.  FieldSpec and BeanSpec can then extend NamedType.
// FIX SC600 checkIsData should take in BeanSpecs.
public final class DefaultDataTestChecker implements DataTestChecker {
    private InstanceTestUtil instancer = new DefaultInstanceTestUtil();
    private ClassTestChecker classChecker = new DefaultClassTestChecker();

    public void checkIsData(Class cls, FieldSpec[] fields) {
        doCheckIsData(cls, fields);
    }

    private void doCheckIsData(Class cls, FieldSpec[] fields) {
        classChecker.checkImplementsAndFinal(cls, Data.class);
        classChecker.checkSubclassOf(cls, Primordial.class);
        //
        // Checks is Data.class
        // Check extends Primordial.class
        // Checks constructor matches provided field specs.
        // Check constructor fails with combinations of nulls.  Including arrays with nulls.
        // Arrays must be copied going in and copied coming out.
        // Can have any number of private methods.
        // Public methods must match field specifications.
        //
        // FIX SC050 Tidy this up.
        ClassTestFixture fixture = new ClassTestFixture(cls, fields);

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