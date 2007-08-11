package au.net.netstorm.boost.nursery.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.introspect.DefaultFieldValueSpec;
import au.net.netstorm.boost.util.introspect.FieldValueSpec;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public class GetterInvocationHandlerDemoTest extends InteractionTestCase implements HasFixtures {
    private Centipede critter1;
    private Centipede critter2;
    String expectedName = null;
    Integer expectedLegs = null;
    RealCentipede realCritter = new RealCentipede("dollar", 1000);

    public void setUpFixtures() {
        critter1 = proxy();
        critter2 = proxy();
    }

    public void testGetStuff() {
        int actualLegs = critter1.getNumLegs();
        assertEquals(expectedLegs, actualLegs);
        String actualName = critter1.getName();
        assertEquals(expectedName, actualName);
    }

    public void testObjectStuff() {
        assertEquals(critter1.hashCode(), critter2.hashCode());
        assertEquals(critter1, critter2);
        assertEquals(critter1.toString(), critter2.toString());
    }

    public void testPerformance() {
        int numLoops = 10000;
        loop(numLoops, critter1);
        loop(numLoops, realCritter);
        System.out.println("critter1 = " + critter1);
    }

    private void loop(int numLoops, Centipede centipede) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < numLoops; i++) {
            centipede.getName();
        }
//        System.out.println("Time for " + numLoops + " loops = " + (System.currentTimeMillis() - start));
    }

    private Centipede proxy() {
        FieldValueSpec nameField = new DefaultFieldValueSpec("name", expectedName);
        FieldValueSpec legsField = new DefaultFieldValueSpec("numLegs", expectedLegs);
        FieldValueSpec[] fields = new FieldValueSpec[]{nameField, legsField};
        return createProxy(Centipede.class, fields);
    }

    private Centipede createProxy(Class type, FieldValueSpec[] fields) {
        InvocationHandler handler = createHandler(type, fields);
        ClassLoader classLoader = getClass().getClassLoader();
        Class[] proxyClasses = new Class[]{type};
        return (Centipede) Proxy.newProxyInstance(classLoader, proxyClasses, handler);
    }

    private InvocationHandler createHandler(Class type, FieldValueSpec[] fields) {
        Interface iFace = new DefaultInterface(type);
        return new GetterInvocationHandler(iFace, fields);
    }
}
