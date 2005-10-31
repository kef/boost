package au.net.netstorm.boost.start;

import junit.framework.TestCase;

public class DefaultBootstrapAtomicTest extends TestCase {
// FIXME: SC509 Reinstate tests.
    public void testFixme() { }
//    private static final VmStyle EASYDOC_VM_STYLE = VmStyle.TASK_PROCESSOR;
//    private final TestMultiCallCoordinator coordinator = new DefaultTestMultiCallCoordinator();
//
//    public void testBootstrap() {
//        Mock mockWirer = createMock(Wirer.class, "wire");
//        Mock mockExporter = createMock(Exporter.class, "export");
//        Mock mockWiringFactory = createFactory(mockWirer, WiringFactory.class);
//        Mock mockExporterFactory = createFactory(mockExporter, ExporterFactory.class);
//        Bootstrapper bootstrapper = createBootstrapper((WiringFactory) mockWiringFactory.proxy(), (ExporterFactory) mockExporterFactory.proxy());
//        bootstrapper.bootstrap(EASYDOC_VM_STYLE);
//    }
//
//    private Mock createFactory(Mock mockExporter, Class type) {
//        Mock mockExporterFactory = createMock(type);
//        mockExporterFactory.expects(createInvocationMatcher()).method("get").with(eq(EASYDOC_VM_STYLE)).will(returnValue(mockExporter.proxy()));
//        return mockExporterFactory;
//    }
//
//    private Mock createMock(Class type, String methodToCall) {
//        Mock mockWirer = createMock(type);
//        expectOneCallTo(methodToCall, mockWirer);
//        return mockWirer;
//    }
//
//    private InvocationMatcher createInvocationMatcher() {
//        return coordinator.nextOrderedInvokeOnceMatcher();
//    }
//
//    private Bootstrapper createBootstrapper(WiringFactory wiringFactory, ExporterFactory exporterFactory) {
//        FieldValueSpec f1 = new DefaultFieldValueSpec("wiringFactory", wiringFactory);
//        FieldValueSpec f2 = new DefaultFieldValueSpec("exporterFactory", exporterFactory);
//        return (Bootstrapper) iocCreate(DefaultBootstrapper.class, new FieldValueSpec[]{f1, f2});
//    }
}
