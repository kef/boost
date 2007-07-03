package au.net.netstorm.boost.spider.inject.newer.field;

import au.net.netstorm.boost.test.atom.DataAtomTestChecker;
import au.net.netstorm.boost.test.core.BoooostCase;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultNewerFieldAtomicTest extends BoooostCase {
    private DataAtomTestChecker checker = new DataAtomTestChecker();
    private FieldSpec f1 = new DefaultFieldSpec("newerInterface", Interface.class);
    private FieldSpec f2 = new DefaultFieldSpec("classToNu", Implementation.class);
    private FieldSpec f3 = new DefaultFieldSpec("fieldName", String.class);
    private FieldSpec[] fields = {f1, f2, f3};

    public void testDataAtom() {
        checker.checkAtom(DefaultNewerField.class, fields);
    }
}
