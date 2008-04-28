package au.net.netstorm.boost.nursery.autoedge;

import java.io.InputStream;
import java.lang.reflect.Method;

import au.net.netstorm.boost.edge.java.io.EdgeInputStream;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultMethodWarpAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private MethodWarp uut;
    private Method src;
    private Method trg;

    public void setUpFixtures() {
        uut = new DefaultMethodWarp();

        EdgeClass cls = new DefaultEdgeClass();
        String name = "read";
        Class<?>[] params = new Class[] { byte[].class };
        src = cls.getMethod(EdgeInputStream.class, name, params);
        trg = cls.getMethod(InputStream.class, name, params);
    }

    public void testWarp() {
        Method result = uut.warp(InputStream.class, src);
        assertEquals(trg, result);
    }

}
