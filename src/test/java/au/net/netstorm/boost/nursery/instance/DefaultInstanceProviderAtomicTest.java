package au.net.netstorm.boost.nursery.instance;

import junit.framework.TestCase;

public final class DefaultInstanceProviderAtomicTest extends TestCase {
//    private static final Integer INTEGER_23 = new Integer(23);
//    private static final Integer INTEGER_32 = new Integer(32);
//    private static final Object POINT_23_32 = new Point(23, 32);
//    private static final Class INTEGER_CLASS = Integer.class;
//    private static final Class POINT_CLASS = Point.class;
    private static final Class OBJECT_CLASS = Object.class;
    private static final Object OBJECT = new Object();
    private InstanceProvider instanceProvider;
    private MockEdgeReflect mockEdgeClass;

    protected void setUp() throws Exception {
        mockEdgeClass = new MockEdgeReflect();
        instanceProvider = new DefaultInstanceProvider(mockEdgeClass);
    }

    // SUGGEST Test drive relevant class properties.
//    public void testClassProperties() {
//        FieldSpec f1 = new DefaultFieldSpec("classBoundary", ClassBoundary.class);
//        ComponentTestUtil.checkComponent(DefaultInstanceProvider.class, InstanceProvider.class, new FieldSpec[]{f1});
//    }

    public void testGetInstanceFromClass() {
        mockEdgeClass.prepare(OBJECT);
        Object actualResult = instanceProvider.newInstance(OBJECT_CLASS);
        assertSame(OBJECT, actualResult);
        assertSame(OBJECT_CLASS, mockEdgeClass.getCls());
    }

    // SUGGEST Implement Boost version of all these bits.
//    public void testGetInstanceSingleArgument() {
//        Object[] arguments = new Object[]{INTEGER_23};
//        Class[] argumentTypes = new Class[]{INTEGER_CLASS};
//        InstanceProvider instanceProvider = getInstanceProvider(INTEGER_23, INTEGER_CLASS, arguments, argumentTypes);
//        Object actualResult = instanceProvider.newInstance(INTEGER_CLASS, INTEGER_23, INTEGER_CLASS);
//        assertSame(INTEGER_23, actualResult);
//    }
//
//    public void testGetInstanceMultipleArguments() {
//        Object[] arguments = new Object[]{INTEGER_23, INTEGER_32};
//        Class[] argumentTypes = new Class[]{INTEGER_CLASS, INTEGER_CLASS};
//        InstanceProvider instanceProvider = getInstanceProvider(POINT_23_32, POINT_CLASS, arguments, argumentTypes);
//        Object actualResult = instanceProvider.newInstance(POINT_CLASS, arguments, argumentTypes);
//        assertSame(POINT_23_32, actualResult);
//    }
//
//    private ClassBoundary setUpClassBoundary() {
//        Mock mock = mock(ClassBoundary.class);
//        expectOneCallTo("newInstance", mock).with(same(OBJECT_CLASS)).will(returnValue(OBJECT));
//        return (ClassBoundary) mock.proxy();
//    }
//
//    private InstanceProvider getInstanceProvider(Object result, Class resultType, Object[] arguments, Class[] argumentTypes) {
//        ClassBoundary classBoundary = setUpClassBoundary(result, resultType, arguments, argumentTypes);
//        return new DefaultInstanceProvider(classBoundary);
//    }
//
//    private ClassBoundary setUpClassBoundary(Object instance, Class instanceType, Object[] arguments, Class[] argumentTypes) {
//        Mock mock = mock(ClassBoundary.class);
//        Constructor constructor = Object.class.getConstructors()[0]; // Any constructor object will do
//        expectOneCallTo("getConstructor", mock).with(eq(instanceType), eq(argumentTypes)).will(returnValue(constructor));
//        expectOneCallTo("newInstance", mock).with(same(constructor), eq(arguments)).will(returnValue(instance));
//        return (ClassBoundary) mock.proxy();
//    }
}
