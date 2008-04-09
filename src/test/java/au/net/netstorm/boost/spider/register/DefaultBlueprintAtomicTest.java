package au.net.netstorm.boost.spider.register;

import au.net.netstorm.boost.bullet.provider.Random;
import au.net.netstorm.boost.gunge.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.gunge.introspect.FieldSpec;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.sniper.atom.AtomTestChecker;
import au.net.netstorm.boost.sniper.atom.LooseDataAtomTestChecker;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultBlueprintAtomicTest extends LifecycleTestCase implements InjectableTest, LazyFields {
    Random random;
    FieldSpec f1 = new DefaultFieldSpec("stamp", Stamp.class);
    FieldSpec f2 = new DefaultFieldSpec("implementation", Implementation.class);
    FieldSpec f3 = new DefaultFieldSpec("parameters", Object[].class);
    FieldSpec[] fields = {f1, f2, f3};

    public void testAtom() {
        AtomTestChecker checker = new LooseDataAtomTestChecker(random);
        checker.checkAtom(DefaultBlueprint.class, fields);
    }
}
