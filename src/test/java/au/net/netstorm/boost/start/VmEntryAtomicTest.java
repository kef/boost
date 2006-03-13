package au.net.netstorm.boost.start;

import au.net.netstorm.boost.reflect.ClassTestChecker;
import au.net.netstorm.boost.reflect.ClassTestUtil;
import au.net.netstorm.boost.reflect.DefaultClassTestChecker;
import au.net.netstorm.boost.reflect.DefaultClassTestUtil;
import au.net.netstorm.boost.reflect.DefaultFieldTestUtil;
import au.net.netstorm.boost.reflect.FieldTestUtil;
import au.net.netstorm.boost.util.introspect.DefaultFieldValueSpec;
import au.net.netstorm.boost.util.introspect.FieldValueSpec;
import junit.framework.TestCase;

// FIXME: SC502 Ensure test for private constructor.

public class VmEntryAtomicTest extends TestCase {
    private static final VmStyle VM_STYLE_PINK_FLOYD = VmStyleAtomicTest.VM_STYLE_PINK_FLOYD;
    private static final VmStyle VM_STYLE_ELO = VmStyleAtomicTest.VM_STYLE_ELO;
    private static final VmStyle VM_STYLE_YES = VmStyleAtomicTest.VM_STYLE_YES;
    private static final String[] TOO_MANY_ARGUMENTS = new String[2];
    private static final String[] TOO_FEW_ARGUMENTS = new String[0];
    private static final String[] NULL = null;
    private final ClassTestChecker clsChecker = new DefaultClassTestChecker();
    private final ClassTestUtil classer = new DefaultClassTestUtil();
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private static final Class VM_ENTRY_CLASS = VmEntry.class;

    public void testInstance() {
        clsChecker.checkSubclassOf(VM_ENTRY_CLASS, getVmEntry());
    }

    public void testProductionBootstrap() {
        Object bootstrap = fielder.getInstance(getVmEntry(), "bootstrapper");
        clsChecker.checkSubclassOf(DefaultBootstrapper.class, bootstrap);
    }

    public void testEntryPoint() {
        checkEntryPoint(VM_STYLE_PINK_FLOYD);
        checkEntryPoint(VM_STYLE_ELO);
        checkEntryPoint(VM_STYLE_YES);
    }

    public void testWithIllegalArguments() {
        checkEntryFails(NULL);
        checkEntryFails(TOO_FEW_ARGUMENTS);
        checkEntryFails(TOO_MANY_ARGUMENTS);
    }

    // FIXME: SC523 Replace with normal test method.
    public void failWithNullStyle() throws IllegalArgumentException {
        callMain(null);
    }

    private void checkEntryPoint(VmStyle style) {
        MockBootstrapper mockBootstrap = new MockBootstrapper();
        createVmEntry(mockBootstrap);
        checkVmEntry(mockBootstrap, style);
    }

    private void createVmEntry(MockBootstrapper mockBootstrap) {
        VmEntry vmEntry = newVmEntry();
        FieldValueSpec fieldValue = new DefaultFieldValueSpec("bootstrapper", mockBootstrap);
        fielder.setInstance(vmEntry, fieldValue);
        fielder.setStatic(VM_ENTRY_CLASS, "instance", vmEntry);
    }

    private void checkVmEntry(MockBootstrapper mockBootstrap, VmStyle style) {
        String[] args = {style.getStyle()};
        VmEntry.main(args);
        VmStyle mockStyle = mockBootstrap.getStyle();
        assertEquals(style, mockStyle);
    }

    private void callMain(String styleString) {
        VmEntry.main(new String[]{styleString});
    }

    private VmEntry getVmEntry() {
        return (VmEntry) fielder.getStatic(VM_ENTRY_CLASS, "instance");
    }

    private void checkEntryFails(String[] args) {
        try {
            VmEntry.main(args);
            fail();
        } catch (Exception expected) { }
    }

    private VmEntry newVmEntry() {
        return (VmEntry) classer.newInstance(VM_ENTRY_CLASS);
    }
}
