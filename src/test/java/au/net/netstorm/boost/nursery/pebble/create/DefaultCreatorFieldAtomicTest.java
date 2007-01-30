package au.net.netstorm.boost.nursery.pebble.create;

import junit.framework.TestCase;
import au.net.netstorm.boost.test.atom.DataAtomTestChecker;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;

public final class DefaultCreatorFieldAtomicTest extends TestCase {
    private DataAtomTestChecker checker = new DataAtomTestChecker();
    private FieldSpec f1 = new DefaultFieldSpec("creatorType", Class.class);
    private FieldSpec f2 = new DefaultFieldSpec("instanceType", Class.class);
    private FieldSpec f3 = new DefaultFieldSpec("fieldName", String.class);
    private FieldSpec[] fields = { f1, f2, f3 };

    public void testDataAtom() {
        checker.checkAtom(DefaultCreateField.class, fields);
    }
}
