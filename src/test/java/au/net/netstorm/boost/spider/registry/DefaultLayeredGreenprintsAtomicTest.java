package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.array.ArrayMaster;
import au.net.netstorm.boost.util.array.DefaultArrayMaster;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultLayeredGreenprintsAtomicTest extends InteractionTestCase implements HasFixtures {
    ArrayMaster arrays = new DefaultArrayMaster();
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
        subject = new LayeredGreenprints(layers);
    }

    public void testTop() {
        expects(true, topMock);
        checkLayer();
    }

    private void checkLayer() {
        checkExists(true);
        checkGet();
    }

    private void checkGet() {
        Blueprint actual = subject.get(iface, flavour);
        assertEquals(blueprint, actual);
    }

    private void checkExists(boolean expected) {
        boolean actual = subject.exists(iface, flavour);
        assertEquals(expected, actual);
    }

    private void expects(boolean exists, Greenprints layer) {
        expect.manyCalls(layer, exists, "exists", iface, flavour);
        if (exists) expect.oneCall(layer, blueprint, "get", iface, flavour);
    }
}
