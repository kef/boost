package au.net.netstorm.boost.spider.instantiate;

import au.net.netstorm.boost.spider.core.NoInterface;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultNuAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    private static final Class SHU = Shu.class;
    private ResolvedInstance resolvedInstance;
    private Object[] params;
    private Shu shu;
    Implementation impl = new DefaultImplementation(SHU);
    Interface iface = new DefaultInterface(NoInterface.class);
    ProviderEngine engineMock;
    Tongue tongueDummy;
    Nu subject;

    public void setUpFixtures() {
        subject = new DefaultNu(engineMock);
        shu = new Shu(tongueDummy);
        resolvedInstance = new DefaultBaseReference(shu);
        params = new Object[]{tongueDummy};
    }

    public void testNu() {
        expect.oneCall(engineMock, resolvedInstance, "provide", iface, impl, params);
        Object actual = subject.nu(SHU, tongueDummy);
        assertEquals(actual, shu);
    }
}