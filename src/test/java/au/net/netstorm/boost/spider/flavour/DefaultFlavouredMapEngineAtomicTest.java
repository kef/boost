package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

// OK NCSS {
public final class DefaultFlavouredMapEngineAtomicTest extends InteractionTestCase implements UsesAutoMocks, HasSubjects {
    private static final String COME_ON_YA_HAVE_TO_GIVE_ME_SOMETHIN_MAN = "Come on, ya have to give me somethin' man.  Anything but a null";
    private static final String UNFLAVOURED_CANNOT_BE_SPECIFIED_WITH_FLAVOURS = "Unflavoured cannot be resolved when flavours exist";
    private static final String UNFLAVOURED_TYPE_ALREADY_REGISTERED = "Unflavoured type already registered";
    private static final String FLAVOUR_ALREADY_EXISTS = "Flavour already exists";
    private static final String NO_MATCHING_FLAVOUR = "No matching flavour";
    private static final String NO_MATCHING_TYPE = "No matching type";
    Interface milkshake = new DefaultInterface(Milkshake.class);
    Interface icecream = new DefaultInterface(IceCream.class);
    Interface chips = new DefaultInterface(Chips.class);
    Interface pie = new DefaultInterface(Pie.class);
    Flavour unflavoured = Flavour.UNFLAVOURED;
    Flavour chocolate = new DefaultFlavour("chocolate");
    Flavour vanilla = new DefaultFlavour("vanilla");
    Flavour strawberry = new DefaultFlavour("strawberry");
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
    FlavouredMapEngine subject;

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

    public void testExistenceWithUnflavouredInMap() {
        checkExists(false, milkshakeUnflavoured);
        checkExists(false, milkshakeChocolate);
        put(milkshakeUnflavoured, value);
        checkExists(true, milkshakeUnflavoured);
        checkExists(true, milkshakeChocolate);
        checkExists(false, icecreamChocolate);
        checkExists(false, icecreamUnflavoured);
    }

    public void testExistenceWithFlavouredInMap() {
        put(milkshakeChocolate, value);
        checkExists(true, milkshakeChocolate);
        checkExists(false, milkshakeUnflavoured);
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

    public void testGetWithUnflavouredInMap() {
        put(milkshakeUnflavoured, value);
        checkGet(milkshakeUnflavoured, value);
        checkGet(milkshakeChocolate, value);
        checkGet(milkshakeVanilla, value);
        checkGetFails(icecreamStrawberry, NO_MATCHING_TYPE);
        checkGetFails(chipsUnflavoured, NO_MATCHING_TYPE);
        checkGetFails(pieStrawberry, NO_MATCHING_TYPE);
    }

    public void testPutWithUnflavouredInMap() {
        put(milkshakeUnflavoured, value);
        checkPutFails(milkshakeChocolate, UNFLAVOURED_TYPE_ALREADY_REGISTERED);
        checkPutFails(milkshakeUnflavoured, UNFLAVOURED_TYPE_ALREADY_REGISTERED);
    }

    public void testPutWithFlavouredInMap() {
        put(icecreamChocolate, value);
        put(icecreamStrawberry, value);
        checkPutFails(icecreamChocolate, FLAVOUR_ALREADY_EXISTS);
        checkPutFails(icecreamUnflavoured, FLAVOUR_ALREADY_EXISTS);
    }

    private void checkExists(boolean expected, FlavouredInterface flavour) {
        boolean result = subject.exists(flavour);
        assertEquals(expected, result);
        // FIX 1977 Complete.
    }

    public void testFailsWithNullValue() {
        checkPutFails(milkshakeUnflavoured, null, COME_ON_YA_HAVE_TO_GIVE_ME_SOMETHIN_MAN);
    }

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
        checkPutFails(flavoured, value, reason);
    }

    private void checkPutFails(FlavouredInterface flavoured, Object value, String reason) {
        try {
            subject.put(flavoured, value);
            fail();
        } catch (FlavourMapException expected) {
            check(reason, expected);
        }
    }

    private void check(String expected, FlavourMapException ex) {
        String msg = ex.getMessage();
        boolean ends = msg.startsWith(expected);
        assertEquals("Message should have started with: \"" + expected + ".\"  Full message was \"" + msg + "\".", true, ends);
    }

    private FlavouredInterface mix(Interface iface, Flavour flavour) {
        return new DefaultFlavouredInterface(iface, flavour);
    }
}
// } OK NCSS - Some nice juicy mixes.  Gotta love it.
