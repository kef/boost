package au.net.netstorm.boost.demo.nursery.autoedge;

import java.lang.reflect.InvocationTargetException;

import demo.edge.java.lang.Class;
import demo.edge.java.lang.ClassStatic;
import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.nursery.autoedge.AutoEdger;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;

public class ClassStaticDemoTest extends LifecycleTestCase implements HasFixtures, InjectableTest {
    private ClassStatic subject;
    AutoEdger edger;

    public void setUpFixtures() {
        subject = edger.edge(ClassStatic.class);
    }

    public void testForName() {
        Class<?> edgedStringClass = subject.forName("java.lang.String");
        java.lang.Class<?> realStringClass = edgedStringClass.unedge();
        assertEquals(String.class, realStringClass);
    }

    public void testForNameFailure() {
        try {
            subject.forName("bad.Name");
            fail();
        } catch (EdgeException e) {
            // FIX 2328 see FIX in DefaultEdgeMethod do we want to change this?
            // assertEquals(true, e.causeIs(ClassNotFoundException.class));
            assertEquals(true, e.causeIs(InvocationTargetException.class));
        }
    }
}
