package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

// FIX BREADCRUMB 1977 LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL Finish this.

// OK NCSS {
public final class DefaultFlavouredMapEngineAtomicTest extends InteractionTestCase implements UsesAutoMocks, HasSubjects {
    private static final String NO_MATCHING_TYPE = "No matching type";
    private static final String NO_MATCHING_FLAVOUR = "No matching flavour";
    private static final String UNFLAVOURED_CANNOT_BE_SPECIFIED_WITH_FLAVOURS = "Unflavoured cannot be resolved when flavours exist";
    private static final String UNFLAVOURED_TYPE_ALREADY_REGISTERED = "Unflavoured type already registered";
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

    // FIX 1977 Test empty failure.

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

    public void testGetWithUnflavouredInMap() {
        put(milkshakeUnflavoured, value);
        checkGet(milkshakeUnflavoured, value);
        checkGet(milkshakeChocolate, value);
        checkGet(milkshakeVanilla, value);
        checkGetFails(icecreamStrawberry, NO_MATCHING_TYPE);
        checkGetFails(chipsUnflavoured, NO_MATCHING_TYPE);
        checkGetFails(pieStrawberry, NO_MATCHING_TYPE);
    }

    public void testGetWithFlavouredInMap() {
        put(icecreamChocolate, value);
        checkGet(icecreamChocolate, value);
        checkGetFails(icecreamStrawberry, NO_MATCHING_FLAVOUR);
        checkGetFails(icecreamUnflavoured, UNFLAVOURED_CANNOT_BE_SPECIFIED_WITH_FLAVOURS);
        checkGetFails(icecreamVanilla, NO_MATCHING_FLAVOUR);
        checkGetFails(pieStrawberry, NO_MATCHING_TYPE);
        checkGetFails(chipsUnflavoured, NO_MATCHING_TYPE);
    }

    public void testPutWithUnflavouredInMap() {
        put(milkshakeUnflavoured, value);
        checkPutFails(milkshakeUnflavoured, UNFLAVOURED_TYPE_ALREADY_REGISTERED);
        checkPutFails(milkshakeChocolate, UNFLAVOURED_TYPE_ALREADY_REGISTERED);
    }

    public void testPutWithFlavouredInMap() {
        put(icecreamChocolate, value);
        put(icecreamStrawberry, value);
        // FIX 1977 Complete.
    }

    // FIX 1977 PutWithFlavourInMap.

    private void put(FlavouredInterface flavour, Object value) {
        subject.put(flavour, value);
    }

    private void checkGet(FlavouredInterface key, Object expected) {
        Object result = subject.get(key);
        assertEquals(expected, result);
    }

    private void checkGetFails(FlavouredInterface flavoured, String reason) {
        try {
            subject.get(flavoured);
            fail();
        } catch (FlavourMapException expected) {
            check(reason, expected);
        }
    }

    private void checkPutFails(FlavouredInterface flavoured, String reason) {
        try {
            subject.put(flavoured, reason);
            fail();
        } catch (FlavourMapException expected) {
            check(reason, expected);
        }
    }

    private void check(String expected, FlavourMapException ex) {
        String msg = ex.getMessage();
        boolean ends = msg.startsWith(expected);
        assertEquals("Message should have started with: \"" + ex + ".\"  Full message was \"" + msg + "\".", true, ends);
    }

    private FlavouredInterface mix(Interface iface, Flavour flavour) {
        return new DefaultFlavouredInterface(iface, flavour);
    }
}
// } OK NCSS - Some nice juicy mixes.
