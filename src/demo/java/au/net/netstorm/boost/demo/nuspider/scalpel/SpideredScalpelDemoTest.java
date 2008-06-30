package au.net.netstorm.boost.demo.nuspider.scalpel;

import au.net.netstorm.boost.demo.nuspider.test.NuSpiderDemooooTest;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.spider.instantiate.NuImpl;
import demo.edge.java.lang.Class;
import demo.edge.java.lang.ClassStatic;

public final class SpideredScalpelDemoTest extends NuSpiderDemooooTest implements InjectableTest {
   NuImpl nuImpl;

   public void testInjectStaticEdge() {
       HasStaticEdge injectable = nuImpl.nu(HasStaticEdge.class);
       ClassStatic classer = injectable.classer;
       String name = SomeClass.class.getName();
       Object expected = new SomeClass();
       checkClassEdge(classer, name, expected);
   }

    private void checkClassEdge(ClassStatic classer, String name, Object expected) {
        Class cls = classer.forName(name);
        Object actual = cls.newInstance();
        assertEquals(expected, actual);
    }
}
