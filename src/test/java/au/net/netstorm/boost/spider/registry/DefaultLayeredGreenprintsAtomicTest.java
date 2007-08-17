package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultLayeredGreenprintsAtomicTest extends InteractionTestCase implements HasFixtures {
    Greenprints live;
    Greenprints dud;
    Greenprints top;
    Greenprints middle;
    Greenprints bottom;
    Interface iface;
    Flavour flavour;
    Blueprint blueprint;

    public void setUpFixtures() {
        live = mock(this.blueprint, true);
        dud = mock(null, false);
        top = prints(live, dud, dud);
        middle = prints(dud, live, live);
        bottom = prints(dud, dud, live);
    }

    public void testLayers() {
        checkLayer(top);
        checkLayer(middle);
        checkLayer(bottom);
    }

    private void checkLayer(Greenprints layer) {
        checkExists(layer);
        checkBlueprint(layer);
    }

    private void checkBlueprint(Greenprints layer) {
        assertEquals(blueprint, layer.get(iface, flavour));
    }

    private void checkExists(Greenprints layer) {
        assertEquals(true, layer.exists(iface, flavour));
    }

    private MockGreenprints mock(Blueprint blueprint, boolean exists) {
        return new MockGreenprints(blueprint, exists, iface, flavour);
    }

    private Greenprints prints(Greenprints g1, Greenprints g2, Greenprints g3) {
        Greenprints[] prints = {g1, g2, g3};
        return new LayeredGreenprints(prints);
    }
}
