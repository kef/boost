package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultLayeredGreenprintsAtomicTest extends InteractionTestCase implements HasFixtures {
    Greenprints top;
    Greenprints middle;
    Greenprints bottom;
    Greenprints[] layers;
    Greenprints subject;
    Interface iface;
    Flavour flavour;

    public void setUpFixtures() {
        layers = new Greenprints[]{top, middle, bottom};
        subject = new DefaultGreenprints(layers);
    }

    // FIX 1914 Complete.
    public void testLayers() {
        subject.exists(iface, flavour);
        subject.get(iface, flavour);
    }
}
