package au.net.netstorm.boost.pebble.create;

import au.net.netstorm.boost.test.atom.DataAtomTestChecker;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.type.Interface;
import junit.framework.TestCase;

public final class DefaultCreatorFieldAtomicTest extends TestCase {
    private DataAtomTestChecker checker = new DataAtomTestChecker();
    private FieldSpec f1 = new DefaultFieldSpec("creatorInterface", Interface.class);
    private FieldSpec f2 = new DefaultFieldSpec("instanceImplementation", Class.class);
    private FieldSpec f3 = new DefaultFieldSpec("fieldName", String.class);
    private FieldSpec[] fields = {f1, f2, f3};

    public void testDataAtom() {
        checker.checkAtom(DefaultCreatorField.class, fields);
    }
}