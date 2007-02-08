package au.net.netstorm.boost.nursery.pebble.create;

import au.net.netstorm.boost.test.atom.DataAtomTestChecker;
import au.net.netstorm.boost.util.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.type.Interface;
import junit.framework.TestCase;

// FIX 1665 Remove all Old classes.
public final class DefaultOldCreatorFieldAtomicTest extends TestCase {
    private DataAtomTestChecker checker = new DataAtomTestChecker();
    private FieldSpec f1 = new DefaultFieldSpec("creatorInterface", Interface.class);
    private FieldSpec f2 = new DefaultFieldSpec("fieldName", String.class);
    private FieldSpec[] fields = {f1, f2};

    public void testDataAtom() {
        checker.checkAtom(DefaultOldCreatorField.class, fields);
    }
}
