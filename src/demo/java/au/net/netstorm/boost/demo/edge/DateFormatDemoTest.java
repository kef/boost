package au.net.netstorm.boost.demo.edge;

import au.net.netstorm.boost.edge.core.AutoEdger;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;

public final class DateFormatDemoTest extends LifecycleTestCase implements InjectableTest {
    AutoEdger edger;

    // FIX 2328 Complete.
    public void testNuSubType() {
//        DateFormat edger.nu(DateFormat.class, SimpleDateFormat.class, "yyyy");
    }
}
