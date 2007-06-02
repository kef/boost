package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

// FIX BREADCRUMB 1977 LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL Finish this.

// OK NCSS {
public final class DefaultFlavouredMapEngineAtomicTest extends InteractionTestCase implements UsesAutoMocks, HasSubjects {
    FlavouredMapEngine subject;
    Interface milkshake = new DefaultInterface(Milkshake.class);
    Interface icecream = new DefaultInterface(IceCream.class);
    Interface chips = new DefaultInterface(Chips.class);
    Interface pie = new DefaultInterface(Pie.class);
    Flavour chocolate = new DefaultFlavour("chocolate");
    Flavour vanilla = new DefaultFlavour("vanilla");
    Flavour strawberry = new DefaultFlavour("strawberry");
    Flavour unflavoured = Flavour.UNFLAVOURED;
    FlavouredInterface milkshakeChocolate = mix(milkshake, chocolate);
    FlavouredInterface milkshakeVanilla = mix(milkshake, vanilla);
    FlavouredInterface milkshakeUnflavoured = mix(milkshake, unflavoured);
    FlavouredInterface icecreamChocolate = mix(icecream, chocolate);
    FlavouredInterface icecreamVanilla = mix(icecream, vanilla);
    FlavouredInterface icecreamStrawberry = mix(icecream, strawberry);
    FlavouredInterface icecreamUnflavoured = mix(icecream, unflavoured);
    FlavouredInterface chipsUnflavoured = mix(chips, unflavoured);
    FlavouredInterface pieStrawberry = mix(pie, strawberry);
    Object value, value1, value2, value3, value4, value5;

    // FIX 1977 Rules:
    // FIX 1977   get(unflavoured) - Must be unflavoured in map.
    // FIX 1977   get(flavoured) - Must be exact matching flavour or unflavoured.
    // FIX 1977   put(unflavoured) - Must be nothing in the map.
    // FIX 1977   put(flavoured) - Must be no unflavoured in the map.
    // FIX 1977 Test empty failure.
    // FIX 1977 Complete.
    // FIX 1977 Check barfs on null value.

    public void setupSubjects() {
        subject = new DefaultFlavouredMapEngine();
    }

    public void testMainFlow() {
        put(milkshakeUnflavoured, value1);
        put(chipsUnflavoured, value2);
        put(icecreamChocolate, value3);
        put(icecreamStrawberry, value4);
        put(pieStrawberry, value5);
        checkGet(milkshakeUnflavoured, value1);
        checkGet(milkshakeChocolate, value1);
        checkGet(milkshakeVanilla, value1);
        checkGet(chipsUnflavoured, value2);
        checkGet(icecreamChocolate, value3);
        checkGet(icecreamStrawberry, value4);
        checkGet(pieStrawberry, value5);
    }

    public void testUnflavouredInMap() {
        put(milkshakeUnflavoured, value);
        checkGet(milkshakeUnflavoured, value);
        checkGet(milkshakeChocolate, value);
        checkGet(milkshakeVanilla, value);
        checkGetFails(icecreamStrawberry);
        checkGetFails(chipsUnflavoured);
        checkGetFails(pieStrawberry);
    }

    public void testFlavouredInMap() {
        put(icecreamChocolate, value);
        checkGet(icecreamChocolate, value);
        checkGetFails(icecreamStrawberry);
        checkGetFails(icecreamUnflavoured);
        checkGetFails(icecreamVanilla);
        checkGetFails(pieStrawberry);
        checkGetFails(chipsUnflavoured);
    }

    private void checkGet(FlavouredInterface key, Object expected) {
        Object result = subject.get(key);
        assertEquals(expected, result);
    }

    private void checkGetFails(FlavouredInterface flavoured) {
        try {
            subject.get(flavoured);
            fail();
        } catch (FlavourMapException expected) { }
    }

    private FlavouredInterface mix(Interface iface, Flavour flavour) {
        return new DefaultFlavouredInterface(iface, flavour);
    }

    // } OK NCSS - A juicy scenario :-)
    private void put(FlavouredInterface flavour, Object value) {
        subject.put(flavour, value);
    }
}
// } OK NCSS - Some nice juicy mixes.
