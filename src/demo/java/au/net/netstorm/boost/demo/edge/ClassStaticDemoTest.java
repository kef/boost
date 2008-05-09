package au.net.netstorm.boost.demo.edge;

import au.net.netstorm.boost.gunge.exception.ThrowableMaster;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import demo.edge.java.lang.ClassStatic;
//FIX 2328 reinstate when default package mapping implemented
public class ClassStaticDemoTest extends LifecycleTestCase implements HasFixtures, InjectableTest {
    private ClassStatic subject;
    ThrowableMaster thrower;
//    AutoEdger edger;

    public void setUpFixtures() {
//        subject = edger.edge(ClassStatic.class);
    }

    public void testForName() {
//        Class<?> edgedStringClass = subject.forName("java.lang.String");
//        Object stringInstance = edgedStringClass.newInstance();
//        assertEquals(String.class, stringInstance.getClass());
    }

    public void testForNameFailure() {
//        try {
//            subject.forName("bad.Name");
//            fail();
//        } catch (EdgeException e) {
//            Throwable real = thrower.rootCause(e);
//            assertEquals(ClassNotFoundException.class, real.getClass());
//        }
    }
}
