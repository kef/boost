package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.gunge.core.LifecycleTestCase;
import au.net.netstorm.boost.gunge.marker.HasFixtures;
import au.net.netstorm.boost.gunge.marker.LazyFields;

public final class DefaultSwizzleMapAtomicTest extends LifecycleTestCase implements LazyFields, HasFixtures {
    private SwizzleMap<Pie, IceCream> subject;
    IceCream neopolitan;
    IceCream vanilla;
    Pie applePie;
    Pie cherryPie;

    public void setUpFixtures() {
        subject = new DefaultSwizzleMap<Pie, IceCream>();
    }

    public void testMap() {
        subject.put(applePie, neopolitan);
        checkSwizzle();
        checkDeswizzle();
    }

    public void testDupeKey() {
        try {
            subject.put(applePie, neopolitan);
            subject.put(applePie, vanilla);
            fail();
        } catch (MapException expected) {
        }
    }

    public void testDupeValue() {
        try {
            subject.put(applePie, neopolitan);
            subject.put(cherryPie, neopolitan);
            fail();
        } catch (MapException expected) {
        }
    }

    private void checkSwizzle() {
        IceCream actual = subject.swizzle(applePie);
        assertEquals(neopolitan, actual);
    }

    private void checkDeswizzle() {
        Pie actual = subject.deswizzle(neopolitan);
        assertEquals(applePie, actual);
    }
}
