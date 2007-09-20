package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultLayeredGreenprintsAtomicTest extends InteractionTestCase implements HasFixtures {
    Greenprints live;
    Greenprints dud;
    Greenprints top;
    Greenprints middle;
    Greenprints bottom;
    Greenprints none;
    Interface iface;
    Blueprint blueprint;

    public void setUpFixtures() {
        live = mock(this.blueprint, true);
        dud = mock(null, false);
        top = prints(live, dud, dud);
        middle = prints(dud, live, live);
        bottom = prints(dud, dud, live);
        none = prints(dud, dud, dud);
    }

    public void testLayers() {
        checkLayer(top);
        checkLayer(middle);
        checkLayer(bottom);
    }

    public void testNone() {
        checkExists(false, none);
        try {
            none.get(iface);
            fail();
        } catch (NonExistentBlueprintException expected) { }
    }

    private void checkLayer(Greenprints layer) {
        checkExists(true, layer);
        checkBlueprint(layer);
    }

    private void checkBlueprint(Greenprints layer) {
        Blueprint actual = layer.get(iface);
        assertEquals(blueprint, actual);
    }

    private void checkExists(boolean expected, Greenprints layer) {
        boolean actual = layer.exists(iface);
        assertEquals(expected, actual);
    }

    private MockGreenprints mock(Blueprint blueprint, boolean exists) {
        return new MockGreenprints(blueprint, exists, iface);
    }

    private Greenprints prints(Greenprints g1, Greenprints g2, Greenprints g3) {
        Greenprints[] prints = {g1, g2, g3};
        return new LayeredGreenprints(prints);
    }
}
