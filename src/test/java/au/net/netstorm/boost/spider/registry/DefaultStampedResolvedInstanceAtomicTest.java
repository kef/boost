package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.InjectableTest;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultStampedResolvedInstanceAtomicTest extends LifecycleTestCase implements InjectableTest, LazyFields {
    AtomTestChecker checker;
    FieldSpec f1 = new DefaultFieldSpec("instance", ResolvedInstance.class);
    FieldSpec f2 = new DefaultFieldSpec("stamp", Stamp.class);
    FieldSpec[] fields = {f1, f2};

    public void testData() {
        checker.checkAtom(DefaultStampedResolvedInstance.class, fields);
    }
}