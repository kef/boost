package au.net.netstorm.boost.demo.nuspider.scalpel;

import au.net.netstorm.boost.demo.nuspider.test.NuSpiderDemooooTest;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.spider.instantiate.NuImpl;
import demo.edge.java.lang.Class;
import demo.edge.java.lang.ClassStatic;

public final class SpideredScalpelStaticDemoTest extends NuSpiderDemooooTest implements InjectableTest {
    NuImpl nu;

    public void testInjectStaticEdge() {
        HasStaticEdge injectable = nu.nu(HasStaticEdge.class);
        ClassStatic classer = injectable.classer;
        checkClassStatic(classer);
    }

    private void checkClassStatic(ClassStatic classer) {
        Class cls = classer.forName("au.net.netstorm.boost.demo.nuspider.scalpel.SomeClass");
        Object actual = cls.newInstance();
        Object expected = new SomeClass();
        assertEquals(expected, actual);
    }
}
