package au.net.netstorm.boost.spider.chain;

import au.net.netstorm.boost.gunge.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.gunge.introspect.FieldSpec;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.sniper.atom.AtomTestChecker;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;

public final class DefaultChainAtomicTest extends LifecycleTestCase implements InjectableTest {
    FieldSpec f1 = new DefaultFieldSpec("type", Interface.class);
    FieldSpec f2 = new DefaultFieldSpec("links", Implementation[].class);
    FieldSpec[] fields = {f1, f2};
    AtomTestChecker checker;

    public void testData() {
        checker.checkAtom(DefaultChain.class, fields);
    }
}