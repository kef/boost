package au.net.netstorm.boost.start;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import au.net.netstorm.boost.util.reflect.ClassPropertiesTestUtil;
import au.net.netstorm.boost.util.reflect.ReflectTestUtil;
import au.net.netstorm.boost.util.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.util.reflect.ReflectMaster;
import au.net.netstorm.boost.util.introspect.DefaultFieldValueSpec;
import au.net.netstorm.boost.util.introspect.FieldValueSpec;
import au.net.netstorm.boost.primordial.PrimordialAtomicTest;
import junit.framework.TestCase;

// FIXME: SC506 Fix failXxx().

public class VmEntryAtomicTest extends TestCase {
    private static final VmStyle VM_STYLE_PINK_FLOYD = new VmStyle("Pink Floyd");
    private static final VmStyle VM_STYLE_ELO = new VmStyle("Electric Light Orchestra");
    private static final VmStyle VM_STYLE_YES = new VmStyle("YES");
    private static final String[] TOO_MANY_ARGUMENTS = new String[2];
    private static final String[] TOO_FEW_ARGUMENTS = new String[0];
    private static final String[] NULL = null;


    private final ReflectMaster reflector = new DefaultReflectMaster();

    // FIXME: SC506 Reinstate all this stuff.
    public void testFixme() {
    }

    public void testInstance() {
        ClassPropertiesTestUtil.checkInstance(VmEntry.class, getVmEntry());
    }

    public void testProductionBootstrap() {
        Object bootstrap = ReflectTestUtil.getInstanceFieldValue(getVmEntry(), "bootstrapper");
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
        ReflectTestUtil.setStaticFieldValue(VmEntry.class, "instance", vmEntry);
    }

    // FIXME: SC502 Move this out into "edge" or some ioc util.
    private VmEntry newVmEntry() {
        Constructor constructor = reflector.getConstructor(VmEntry.class);
        Object[] args = {};
        try {
            constructor.setAccessible(true);
            return (VmEntry) constructor.newInstance(args);
            // FIXME: SC502 Move to "edge"
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private void checkVmEntry(MockBootstrapper mockBootstrap, VmStyle style) {
        VmEntry.main(new String[]{style.getStyle()});
        assertEquals(style, mockBootstrap.getStyle());
    }

    private void callMain(String styleString) {
        VmEntry.main(new String[]{styleString});
    }

    private VmEntry getVmEntry() {
        return (VmEntry) ReflectTestUtil.getStaticFieldValue(VmEntry.class, "instance");
    }

    private void checkEntryFails(String[] args) {
        try {
            VmEntry.main(args);
            fail();
        } catch (Exception expected) { }
    }
}
