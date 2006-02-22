package au.net.netstorm.boost.start;

import java.lang.reflect.Constructor;

import au.net.netstorm.boost.primordial.PrimordialAtomicTest;
import au.net.netstorm.boost.util.introspect.DefaultFieldValueSpec;
import au.net.netstorm.boost.util.introspect.FieldValueSpec;
import au.net.netstorm.boost.util.reflect.ClassPropertiesTestUtil;
import au.net.netstorm.boost.util.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.util.reflect.ReflectEdge;
import au.net.netstorm.boost.util.reflect.ReflectMaster;
import au.net.netstorm.boost.util.reflect.DefaultReflectTestUtil;
import au.net.netstorm.boost.util.reflect.ReflectTestUtil;
import junit.framework.TestCase;

// FIXME: SC506 Fix failXxx().

public class VmEntryAtomicTest extends TestCase {
    private static final VmStyle VM_STYLE_PINK_FLOYD = VmStyleAtomicTest.VM_STYLE_PINK_FLOYD;
    private static final VmStyle VM_STYLE_ELO = VmStyleAtomicTest.VM_STYLE_ELO;
    private static final VmStyle VM_STYLE_YES = VmStyleAtomicTest.VM_STYLE_YES;
    private static final String[] TOO_MANY_ARGUMENTS = new String[2];
    private static final String[] TOO_FEW_ARGUMENTS = new String[0];
    private static final String[] NULL = null;

    // FIXME: SC502 Ensure test for private constructor.

    private final ReflectMaster reflector = new DefaultReflectMaster();
    private final ReflectTestUtil testReflector = new DefaultReflectTestUtil();

    // FIXME: SC506 Reinstate all this stuff.
    public void testFixme() {
    }

    public void testInstance() {
        ClassPropertiesTestUtil.checkInstance(VmEntry.class, getVmEntry());
    }

    public void testProductionBootstrap() {
        Object bootstrap = testReflector.getInstanceFieldValue(getVmEntry(), "bootstrapper");
        ClassPropertiesTestUtil.checkInstance(DefaultBootstrapper.class, bootstrap);
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
        // FIXME: SC502 There is duplicate code in PrimordialAtomicTest.
        FieldValueSpec fieldValue = new DefaultFieldValueSpec("bootstrapper", mockBootstrap);
        PrimordialAtomicTest.resolveField(vmEntry, fieldValue);
        testReflector.setStaticFieldValue(VmEntry.class, "instance", vmEntry);
    }

    // FIXME: SC502 Move this out into "edge" or some ioc util.
    private VmEntry newVmEntry() {
        Constructor constructor = reflector.getConstructor(VmEntry.class);
        Object[] args = {};
        constructor.setAccessible(true);
        return (VmEntry) ReflectEdge.INSTANCE.newInstance(constructor, args);
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
        return (VmEntry) testReflector.getStaticFieldValue(VmEntry.class, "instance");
    }

    private void checkEntryFails(String[] args) {
        try {
            VmEntry.main(args);
            fail();
        } catch (Exception expected) { }
    }
}
