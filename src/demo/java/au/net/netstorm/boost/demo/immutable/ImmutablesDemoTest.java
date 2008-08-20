package au.net.netstorm.boost.demo.immutable;

import static au.net.netstorm.boost.gunge.separator.Separator.LINE;
import au.net.netstorm.boost.sniper.marker.HasFixtures;

public final class ImmutablesDemoTest extends ImmutablesTest implements HasFixtures {
    Socker socker = spider.resolve(Socker.class);

    public void setUpFixtures() {
    }

    public void testEquality() {
        Sock s1 = socker.sock();
        Sock s2 = socker.sock();
        assertEquals(true, s1 != s2);
        assertEquals(s1, s2);
    }

    public void testString() {
        Sock sock = socker.sock();
        assertEquals(string(), "" + sock);
    }

    private String string() {
        return "Sock[" + LINE +
                "    host=Host[doggdot.us]" + LINE +
                "    port=Port[8081]" + LINE +
                "]";
    }
}
