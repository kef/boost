package au.net.netstorm.boost.log;

import au.net.netstorm.boost.gunge.atom.ConstructorNullDataChecker;
import au.net.netstorm.boost.gunge.atom.DataChecker;
import au.net.netstorm.boost.gunge.core.LifecycleTestCase;
import au.net.netstorm.boost.gunge.marker.HasFixtures;
import au.net.netstorm.boost.gunge.marker.InjectableTest;
import au.net.netstorm.boost.gunge.marker.LazyFields;
import au.net.netstorm.boost.gunge.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.provider.Random;
import au.net.netstorm.boost.spider.instantiate.Nu;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class DefaultLogLevelAtomicTest extends LifecycleTestCase implements InjectableTest, HasFixtures, LazyFields {
    private FieldSpec f1 = new DefaultFieldSpec("name", String.class);
    private DataChecker checker;
    FieldTestUtil fielder;
    Random random;
    String name;
    Nu nu;

    public void test() {
        checker.check(DefaultLogLevel.class, new FieldSpec[]{f1});
        LogLevel level = new DefaultLogLevel(name);
        Object actual = fielder.getInstance(level, "name");
        assertEquals(name, actual);
    }

    public void setUpFixtures() {
        checker = nu.nu(ConstructorNullDataChecker.class, random);
    }
}