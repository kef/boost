package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultLayeredGreenprintsAtomicTest extends InteractionTestCase implements HasFixtures {
    Greenprints topMock;
    Greenprints middleMock;
    Greenprints bottomMock;
    Greenprints[] layers;
    Greenprints subject;
    Interface iface;
    Flavour flavour;
    Blueprint blueprint;

    public void setUpFixtures() {
        layers = new Greenprints[]{topMock, middleMock, bottomMock};
        subject = new DefaultGreenprints(layers);
    }

    // FIX 1914 Complete.
    public void testLayers() {
        expect.oneCall(topMock, true, "exists", iface, flavour);
        expect.oneCall(topMock, blueprint, "get", iface, flavour);
        subject.exists(iface, flavour);
        subject.get(iface, flavour);
    }
}
