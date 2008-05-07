package au.net.netstorm.boost.spider.linkage;

import au.net.netstorm.boost.gunge.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.gunge.introspect.FieldSpec;
import au.net.netstorm.boost.sniper.atom.AtomTestChecker;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public class DefaultAnchorAtomicTest extends LifecycleTestCase implements InjectableTest, LazyFields {
    AtomTestChecker checker;
    FieldSpec f1 = new DefaultFieldSpec("Name", String.class);
    FieldSpec[] fields = {f1};

    public void testData() {
        checker.checkAtom(DefaultAnchor.class, fields);
    }
}
