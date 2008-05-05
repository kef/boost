package au.net.netstorm.boost.spider.instantiate;

import au.net.netstorm.boost.gunge.type.DefaultBaseReference;
import au.net.netstorm.boost.gunge.type.DefaultImplementation;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.ResolvedInstance;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.core.ProviderEngine;

public final class DefaultNuAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    private static final Class SHU = Shu.class;
    private ResolvedInstance resolvedInstance;
    private Object[] params;
    private Shu shu;
    Implementation impl = new DefaultImplementation(SHU);
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
        expect.oneCall(engineMock, resolvedInstance, "provide", impl, params);
        Object actual = subject.nu(SHU, tongueDummy);
        assertEquals(actual, shu);
    }
}