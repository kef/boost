package au.net.netstorm.boost.nursery.immutable;

import au.net.netstorm.boost.gunge.introspect.FieldValueSpec;
import au.net.netstorm.boost.gunge.proxy.ProxyFactory;
import au.net.netstorm.boost.gunge.type.DefaultInterface;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public class DataInvocationHandlerDemoTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    private static final Interface CENTIPEDE = new DefaultInterface(Centipede.class);
    private static final String NUM_LEGS = "numLegs";
    private static final String NAME = "name";
    private Centipede critter1;
    private Centipede critter2;
    private FieldValueSpec legsSpec;
    private FieldValueSpec nameSpec;
    String expectedName = null;
    Integer expectedLegs = null;
    ProxyFactory proxies;
    RealCentipede realCritter = new RealCentipede("dollar", 1000);
    private static final int NUM_LOOPS = 10000000;

    public void setUpFixtures() {
    }

    // FIX 2130 Consider reinstating this vom.
    // FIX 2130 Otherwise smash.
    public void testXxx() {
    }

//    public void setUpFixtures() {
//        legsSpec = new DefaultFieldValueSpec(NUM_LEGS, expectedLegs);
//        nameSpec = new DefaultFieldValueSpec(NAME, expectedName);
//        critter1 = proxy(nameSpec, legsSpec);
//        critter2 = proxy(nameSpec, legsSpec);
//    }
//
//    // FIX DATAPROXY 2130 Get this working
////    public void testMissingFieldsThrowsException() {
////        FieldValueSpec[] fields = new FieldValueSpec[0];
////        checkThrowsWithMessage(Centipede.class, fields, "No field supplied for method ");
////    }
//
//    public void testExtraFieldsThrowsException() {
//        FieldValueSpec extra = new DefaultFieldValueSpec("extra", "extra");
//        FieldValueSpec[] fields = {legsSpec, nameSpec, extra};
//        checkThrowsWithMessage(CENTIPEDE, fields, "Number of methods(2) and fields(3) differ");
//    }
//
//    // FIX DATAPROXY 2130 Get this working
////    public void testWrongTypeThrowsException() {
////        FieldValueSpec wrong = new DefaultFieldValueSpec(NUM_LEGS, "should be an int");
////        FieldValueSpec[] fields = {wrong, nameSpec};
////        checkThrowsWithMessage(Centipede.class, fields, "No field supplied for method ");
////    }
//
//    // FIX DATAPROXY 2130 Get this working
////    public void testPrimitives() {
////        FieldValueSpec[] fields = {new DefaultFieldValueSpec("someInt", new Integer(1))};
////        checkThrowsWithMessage(PrimativeTestInterface.class, fields, "Primitive return types not supported");
////    }
//
//    public void testGetStuff() {
//        int actualLegs = critter1.numLegs().intValue();
//        assertEquals(expectedLegs, actualLegs);
//        String actualName = critter1.name();
//        assertEquals(expectedName, actualName);
//    }
//
//    // FIX DATAPROXY 2130 Get this working
////    public void testObjectStuff() {
////        assertEquals(critter1.hashCode(), critter2.hashCode());
////    }
    //        long proxyTime = loop(NUM_LOOPS, critter1);
    //        // FIX DATAPROXY 2130 This looks like bullshit.  (4x doesn't work all the time here either.)
    //        //assertEquals(true, proxyTime < 5 * realTime);
    //    private void checkThrowsWithMessage(Interface iface, FieldValueSpec[] fields, String messageStart) {
    //            fail();
    //            assertEquals(true, message.startsWith(messageStart));
    //
    //        for (int i = 0; i < numLoops; i++) {
    //        return System.currentTimeMillis() - start;
    //    private Centipede proxy(FieldValueSpec name, FieldValueSpec legs) {
    //    }
    //        Layer layer = new DataLayer(CENTIPEDE, fields);
    //
    //        int someInt();
////        assertEquals(critter1, critter2);
////        assertEquals(critter1.toString(), critter2.toString());
//
//    public void testPerformance() {
//        long realTime = loop(NUM_LOOPS, realCritter);
//        // FIX DATAPROXY 2130 Is this an appropriate ratio? (NOTE: 3x doesn't pass on geekscape.)
//        // FIX DATAPROXY 2130 This looks like bullshit.  Not working on our crap build boxes
//
//    }
//
//        try {
//            proxy(iface, fields);
//        } catch (IllegalArgumentException actual) {
//            String message = actual.getMessage();
//        }
//    }
//    private long loop(int numLoops, Centipede centipede) {
//        long start = System.currentTimeMillis();
//            centipede.name();
//        }
//    }
//
//        FieldValueSpec[] fields = new FieldValueSpec[]{name, legs};
//        return proxy(CENTIPEDE, fields);
//
//    private Centipede proxy(Interface iface, FieldValueSpec[] fields) {
//        return (Centipede) proxies.newProxy(CENTIPEDE, layer);
//    }
//    private interface PrimitiveTestInterface {

//    }
}
