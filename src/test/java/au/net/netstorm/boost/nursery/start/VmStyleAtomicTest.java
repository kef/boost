package au.net.netstorm.boost.nursery.start;

import au.net.netstorm.boost.gunge.introspect.DefaultFieldSpec;
import au.net.netstorm.boost.gunge.introspect.FieldSpec;
import au.net.netstorm.boost.sniper.atom.AtomTestChecker;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public class VmStyleAtomicTest extends LifecycleTestCase implements InjectableTest, LazyFields {
    public static final VmStyle VM_STYLE_PINK_FLOYD = new VmStyle("Pink Floyd");
    public static final VmStyle VM_STYLE_ELO = new VmStyle("Electric Light Orchestra");
    public static final VmStyle VM_STYLE_YES = new VmStyle("YES");
    FieldSpec f1 = new DefaultFieldSpec("style", String.class);
    FieldSpec[] fields = {f1};
    AtomTestChecker checker;

    public void testIsDataObject() {
        checker.checkAtom(VmStyle.class, fields);
    }

    public void testNull() {
        try {
            new VmStyle(null);
        } catch (IllegalArgumentException e) {
            assertEquals("style parameter cannot be null", e.getMessage());
        }
    }
}
