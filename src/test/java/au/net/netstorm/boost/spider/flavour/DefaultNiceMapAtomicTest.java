package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.nursery.util.type.DefaultInterface;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;

// FIX 2237 This probably goes when flavours are reinstated.

// OK NCSS {
public final class DefaultNiceMapAtomicTest extends LifecycleTestCase implements LazyFields, HasFixtures {
    private static final String COME_ON_YA_HAVE_TO_GIVE_ME_SOMETHIN_MAN = "Come on, ya have to give me somethin' man.  Anything but a null";
    AllowOverrides overrides = new DefaultAllowOverrides();
    FieldTestUtil fielder = new DefaultFieldTestUtil();
    Interface icecream = new DefaultInterface(IceCream.class);
    Interface milkshake = new DefaultInterface(Milkshake.class);
    Interface chips = new DefaultInterface(Chips.class);
    Interface pie = new DefaultInterface(Pie.class);
    Object value, value1, value2, value3, value4;
    StrictMap subject;

    public void setUpFixtures() {
        subject = new DefaultStrictMap();
    }

    public void testMainFlow() {
        put(milkshake, value1);
        put(chips, value2);
        put(icecream, value3);
        put(pie, value4);
        checkGet(milkshake, value1);
        checkGet(chips, value2);
        checkGet(icecream, value3);
        checkGet(pie, value4);
    }

    public void testExistence() {
        put(milkshake, value);
        checkExists(true, milkshake);
        checkExists(false, pie);
    }

    public void testRemove() {
        put(milkshake, value);
        put(chips, value);
        subject.remove(milkshake);
        checkExists(false, milkshake);
        checkExists(true, chips);
    }

    public void testClear() {
        put(chips, value);
        put(milkshake, value);
        subject.clear();
        checkExists(false, milkshake);
        checkExists(false, chips);
    }

    public void testPutFails() {
        put(milkshake, value);
        checkPutFails(milkshake, "Key already exists");
    }

    public void testPutOverrides() {
        put(milkshake, value);
        putWithOverride(milkshake, value);
    }

    public void testGetFails() {
        checkGetFails(milkshake, "No matching key");
    }

    public void testFailsWithNullValue() {
        checkPutFails(milkshake, null, COME_ON_YA_HAVE_TO_GIVE_ME_SOMETHIN_MAN);
    }

    private void checkExists(boolean expected, Interface iface) {
        boolean result = subject.exists(iface);
        assertEquals(expected, result);
    }

    private void put(Interface iface, Object value) {
        subject.put(iface, value);
    }

    private void putWithOverride(final Interface iface, final Object value) {
        overrides.withOverride(new Runnable() {
            public void run() {
                subject.put(iface, value);
            }
        });
    }

    private void checkGet(Interface key, Object expected) {
        Object result = subject.get(key);
        assertEquals(expected, result);
    }

    private void checkGetFails(Interface iface, String reason) {
        try {
            subject.get(iface);
            fail();
        } catch (MapException expected) {
            check(reason, expected);
        }
    }

    private void checkPutFails(Interface iface, String reason) {
        checkPutFails(iface, value, reason);
    }

    private void checkPutFails(Interface iface, Object value, String reason) {
        try {
            subject.put(iface, value);
            fail();
        } catch (MapException expected) {
            check(reason, expected);
        }
    }

    private void check(String expected, MapException ex) {
        String msg = ex.getMessage();
        boolean ends = msg.startsWith(expected);
        assertEquals("Message should have started with: \"" + expected + ".\"  Full message was \"" + msg + "\".", true, ends);
        boolean resolvedThings = msg.endsWith("[]");
        assertEquals(true, resolvedThings);
    }
}
// } OK NCSS - Some nice juicy mixes.  Gotta love it.
