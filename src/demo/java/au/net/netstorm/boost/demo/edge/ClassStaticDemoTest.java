package au.net.netstorm.boost.demo.edge;

import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import au.net.netstorm.boost.scalpel.core.AutoEdger;
import au.net.netstorm.boost.sledge.support.EdgeException;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import demo.edge.java.lang.Class;
import demo.edge.java.lang.ClassStatic;

public class ClassStaticDemoTest extends EdgeDemooooTest implements HasFixtures {
    private ClassStatic subject;
    ThrowableMaster thrower;
    AutoEdger edger;

    public void setUpFixtures() {
        subject = edger.edge(ClassStatic.class);
    }

    public void testForName() {
        Class<?> edgedStringClass = subject.forName("java.lang.String");
        Object stringInstance = edgedStringClass.newInstance();
        assertEquals(String.class, stringInstance.getClass());
    }

    public void testForNameFailure() {
        try {
            subject.forName("bad.Name");
            fail();
        } catch (EdgeException e) {
            Throwable real = thrower.rootCause(e);
            assertEquals(ClassNotFoundException.class, real.getClass());
        }
    }
}
