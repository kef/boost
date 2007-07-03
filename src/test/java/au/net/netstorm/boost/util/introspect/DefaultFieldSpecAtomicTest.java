package au.net.netstorm.boost.util.introspect;

import au.net.netstorm.boost.test.atom.AtomTestChecker;
import au.net.netstorm.boost.test.atom.DataAtomTestChecker;
import au.net.netstorm.boost.test.core.BoooostCase;

public class DefaultFieldSpecAtomicTest extends BoooostCase {
    private final FieldSpec f1 = new DefaultFieldSpec("name", String.class);
    private final FieldSpec f2 = new DefaultFieldSpec("type", Class.class);
    private final FieldSpec[] fields = {f1, f2};
    private AtomTestChecker data = new DataAtomTestChecker();

    public void testData() {
        data.checkAtom(DefaultFieldSpec.class, fields);
    }
}
