package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.test.cases.BoooostCase;

public final class FlavourAtomicTest extends BoooostCase {
    private final Flavour unflavoured = new DefaultFlavour("No taste buds ... totally unflavoured");

    public void testUnflavoured() {
        Flavour actual = Flavour.UNFLAVOURED;
        assertEquals(unflavoured, actual);
    }
}
