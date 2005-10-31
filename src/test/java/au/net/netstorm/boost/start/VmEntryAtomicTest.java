package au.net.netstorm.boost.start;

import au.net.netstorm.boost.util.reflect.ClassPropertiesTestUtil;
import au.net.netstorm.boost.util.reflect.ReflectTestUtil;
import junit.framework.TestCase;

// FIXME: SC501 Fix failXxx().

public class VmEntryAtomicTest extends TestCase {
    private static final VmStyle VM_STYLE_BANANA = new VmStyle("banana");
    private static final VmStyle VM_STYLE_REAL = new VmStyle("real");
    private static final VmStyle VM_STYLE_PRINT = new VmStyle("print");

    // FIXME: SC501 Reinstate all this stuff.
    public void testFixme() {
    }

    public void testInstance() {
        ClassPropertiesTestUtil.checkInstance(VmEntry.class, getVmEntry());
    }
//
//    public void testProductionBootstrap() {
//        Object bootstrap = ReflectTestUtil.getInstanceFieldValue(getVmEntry(), "bootstrapper");
//        ClassPropertiesTestUtil.checkInstance(DefaultBootstrapper.class, bootstrap);
//    }
//
//    public void testEntryPoint() {
//        checkEntryPoint(VM_STYLE_REAL);
//        checkEntryPoint(VM_STYLE_PRINT);
//        checkEntryPoint(VM_STYLE_BANANA);
//    }
//

    public void testWithNullArguments() throws IllegalArgumentException {
        try {
            VmEntry.main(null);
        } catch (Exception expected) { }
    }
//
//    public void failWithNotEnoughArguments() throws IllegalArgumentException {
//        VmEntry.main(new String[0]);
//    }
//
//    public void failWithTooManyArguments() throws IllegalArgumentException {
//        VmEntry.main(new String[2]);
//    }
//
//    public void failWithNullStyle() throws IllegalArgumentException {
//        callMain(null);
//    }
//
//    private void checkEntryPoint(VmStyle style) {
//        MockBootstrapper mockBootstrap = new MockBootstrapper();
//        createVmEntry(mockBootstrap);
//        checkVmEntry(mockBootstrap, style);
//    }
//
//    private void createVmEntry(MockBootstrapper mockBootstrap) {
//        FieldValueSpec fieldValue = new DefaultFieldValueSpec("bootstrapper", mockBootstrap);
//        VmEntry vmEntry = (VmEntry) iocCreate(VmEntry.class, new FieldValueSpec[]{fieldValue});
//        ReflectTestUtil.setStaticFieldValue(VmEntry.class, "instance", vmEntry);
//    }
//
//    private void checkVmEntry(MockBootstrapper mockBootstrap, VmStyle style) {
//        VmEntry.main(new String[]{style.getStyle()});
//        assertEquals(style, mockBootstrap.getStyle());
//    }
//
//    private void callMain(String styleString) {
//        VmEntry.main(new String[]{styleString});
//    }
//

    private VmEntry getVmEntry() {
        return (VmEntry) ReflectTestUtil.getStaticFieldValue(VmEntry.class, "instance");
    }
}
