package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

// FIX BREADCRUMB 1977 LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL Finish this.
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

    // OK NCSS {
    public void testMainFlow() {
        subject.put(milkshakeUnflavoured, value1);
        subject.put(chipsUnflavoured, value2);
        subject.put(icecreamChocolate, value3);
        subject.put(icecreamStrawberry, value4);
        subject.put(pieStrawberry, value5);
        checkGet(value1, milkshakeUnflavoured);
        // FIX BREADCRUMB 1977 QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ Instate these next.
/*
        checkGet(value1, milkshakeChocolate);
        checkGet(value1, milkshakeVanilla);
*/
        checkGet(value2, chipsUnflavoured);
        checkGet(value3, icecreamChocolate);
        checkGet(value4, icecreamStrawberry);
        checkGet(value5, pieStrawberry);
    }
    // } OK NCSS - A juicy scenario :-) 

    private void checkGet(Object expected, FlavouredInterface key) {
        Object result = subject.get(key);
        assertEquals(expected, result);
    }

    public void testUnflavoured() {
        subject.put(milkshakeUnflavoured, value);
        // FIX BREADCRUMB 1977 MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM Reinstate.
/*
        try {
            subject.put(milkshakeChocolate, value);
            fail();
        } catch (FlavouredMapException expected) { }
*/
    }

    private FlavouredInterface mix(Interface iface, Flavour flavour) {
        return new DefaultFlavouredInterface(iface, flavour);
    }
}
