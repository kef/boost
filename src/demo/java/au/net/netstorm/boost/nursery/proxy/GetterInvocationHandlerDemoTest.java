package au.net.netstorm.boost.nursery.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.introspect.DefaultFieldValueSpec;
import au.net.netstorm.boost.util.introspect.FieldValueSpec;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public class GetterInvocationHandlerDemoTest extends InteractionTestCase implements HasFixtures {
    Integer expectedLegs = null;
    String expectedName = null;
    private Centipede critter1;
    private Centipede critter2;

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
        int numLoops = 10000000;
        loop(numLoops, critter1);
        loop(numLoops, new RealCentipede());
    }

    private void loop(int numLoops, Centipede centipede) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < numLoops; i++) {
            centipede.getName();
        }
        System.out.println("Time for " + numLoops + " loops = " + (System.currentTimeMillis() - start));
    }

    private Centipede proxy() {
        ClassLoader classLoader = getClass().getClassLoader();
        Class[] proxyClasses = new Class[]{Centipede.class};
        Interface iFace = new DefaultInterface(Centipede.class);
        InvocationHandler handler = handler(iFace);
        return (Centipede) Proxy.newProxyInstance(classLoader, proxyClasses, handler);
    }

    private InvocationHandler handler(Interface iFace) {
        FieldValueSpec nameField = new DefaultFieldValueSpec("name", expectedName);
        FieldValueSpec legsField = new DefaultFieldValueSpec("numLegs", expectedLegs);
        FieldValueSpec[] fields = new FieldValueSpec[]{nameField, legsField};
        return new GetterInvocationHandler(iFace, fields);
    }

    public interface Centipede {
        int getNumLegs();

        String getName();
    }

    public class RealCentipede extends Primordial implements Centipede {
        private final String name = "Fred";
        private final int numLegs = 1000;

        public int getNumLegs() {
            return numLegs;
        }

        public String getName() {
            return name;
        }
    }
}
