package au.net.netstorm.boost.nursery.factory;

public final class FactoryTestUtil {
    private FactoryTestUtil() {
    }

    // SUGGEST Build up Boost version of this.
//    private static final IocFactory IOC = new DefaultIocFactory();
//    private static final MockIocFactory NULL_IOC_FACTORY = new MockIocFactory(null, null, null);
//
//    public static void checkGet(Class factoryInterfaceType, Class factoryImplType,
//                                Class[] paramTypesForGet, FieldValueSpec[] fieldSpecsForGet,
//                                Class returnInterfaceType, Class returnImplType, Object expectedResult) {
//        checkGet(factoryInterfaceType, factoryImplType,
//                paramTypesForGet, fieldSpecsForGet, new FieldValueSpec[]{},
//                returnInterfaceType, returnImplType, expectedResult);
//    }
//
//    public static void checkGet(Class factoryInterfaceType, Class factoryImplType,
//                                Class[] paramTypesForGet, FieldValueSpec[] fieldSpecsForGet, FieldValueSpec[] extraDependenciesForGet,
//                                Class returnInterfaceType, Class returnImplType, Object expectedResult) {
//        checkInterfaceProperties(factoryInterfaceType, factoryImplType, paramTypesForGet, returnInterfaceType);
//        checkGetValid(factoryImplType, paramTypesForGet, fieldSpecsForGet, extraDependenciesForGet, returnImplType, expectedResult);
//        checkGetNullParamValues(paramTypesForGet, createParamsForGet(fieldSpecsForGet), extraDependenciesForGet, factoryImplType);
//    }
//
//    private static void checkInterfaceProperties(Class factoryInterfaceType, Class factoryImplType,
//                                                 Class[] paramTypesForGet, Class returnType) {
//        Assert.assertTrue("The " + factoryImplType + " should implement " + factoryInterfaceType,
//                factoryInterfaceType.isAssignableFrom(factoryImplType));
//        Method method = getMethod(factoryInterfaceType, paramTypesForGet);
//        Assert.assertNotNull(method);
//        Assert.assertEquals(returnType, method.getReturnType());
//    }
//
//    private static void checkGetNullParamValues(Class[] paramTypesForGet, Object[] paramsForGet, FieldValueSpec[] extraDependenciesForGet,
//                                                Class returnImplType) {
//        for (int i = 0; i < paramsForGet.length; i++) {
//            Object[] newParamsForGet = (Object[]) paramsForGet.clone();
//            newParamsForGet[i] = null;
//            checkGetNullParamValue(returnImplType, newParamsForGet, paramTypesForGet, extraDependenciesForGet);
//        }
//    }
//
//    private static void checkGetNullParamValue(Class implType, Object[] paramsForGet, Class[] paramTypesForGet,
//                                               FieldValueSpec[] extraDependencies) {
//        try {
//            get(implType, NULL_IOC_FACTORY, paramsForGet, paramTypesForGet, extraDependencies);
//            Assert.fail("Expected IllegalArgumentException not thrown.");
//        } catch (InvocationTargetException expected) {
//            checkCause(expected);
//        }
//    }
//
//    private static Method getMethod(Class factoryInterfaceType, Class[] paramTypesForGet) {
//        try {
//            return factoryInterfaceType.getMethod("get", paramTypesForGet);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private static Object[] createParamsForGet(FieldValueSpec[] fieldSpecsForGet) {
//        Object[] paramsForGet = new Object[fieldSpecsForGet.length];
//        for (int i = 0; i < fieldSpecsForGet.length; i++) {
//            paramsForGet[i] = fieldSpecsForGet[i].getValue();
//        }
//        return paramsForGet;
//    }
//
//    private static Object tryGet(Class implType, MockIocFactory iocFactory, Object[] paramsForGet, Class[] paramTypesForGet,
//                                 FieldValueSpec[] extraDependencies) {
//        try {
//            return get(implType, iocFactory, paramsForGet, paramTypesForGet, extraDependencies);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private static Object get(Class implType, IocFactory iocFactory, Object[] paramsForGet, Class[] paramTypesForGet,
//                              FieldValueSpec[] extraDependencies)
//            throws InvocationTargetException {
//        Object factory = createFactory(implType, iocFactory, extraDependencies);
//        Method method = getMethod(implType, paramTypesForGet);
//        return invoke(method, factory, paramsForGet);
//    }
//
//    private static Object createFactory(Class factoryImplType, IocFactory iocFactory, FieldValueSpec[] extraDependencies) {
//        FieldValueSpec fieldSpec = new DefaultFieldValueSpec("iocFactory", iocFactory);
//        FieldValueSpec[] dependencies = mergeFieldSpecs(new FieldValueSpec[]{fieldSpec}, extraDependencies);
//        return IOC.create(factoryImplType, dependencies);
//    }
//
//    private static Object invoke(Method method, Object factory, Object[] paramsForGet) throws InvocationTargetException {
//        try {
//            return method.invoke(factory, paramsForGet);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private static void checkCause(InvocationTargetException expected) {
//        Throwable cause = expected.getCause();
//        Assert.assertNotNull(cause);
//        Assert.assertTrue(cause instanceof IllegalArgumentException);
//    }
//
//    private static void checkGetValid(Class factoryImplType,
//                                      Class[] paramTypesForGet, FieldValueSpec[] fieldSpecsForGet, FieldValueSpec[] extraDependenciesForGet,
//                                      Class returnImplType, Object expectedResult) {
//        FieldValueSpec[] expectedFieldSpecsForGet = mergeFieldSpecs(fieldSpecsForGet, extraDependenciesForGet);
//        MockIocFactory iocFactory = new MockIocFactory(expectedResult, returnImplType, expectedFieldSpecsForGet);
//        Object[] paramsForGet = createParamsForGet(fieldSpecsForGet);
//        Object actual = tryGet(factoryImplType, iocFactory, paramsForGet, paramTypesForGet, extraDependenciesForGet);
//        iocFactory.check();
//        Assert.assertEquals(expectedResult, actual);
//    }
//
//    private static FieldValueSpec[] mergeFieldSpecs(FieldValueSpec[] fieldSpecs, FieldValueSpec[] additionalFieldSpecs) {
//        FieldValueSpec[] mergedFieldSpecs = new FieldValueSpec[fieldSpecs.length + additionalFieldSpecs.length];
//        System.arraycopy(fieldSpecs, 0, mergedFieldSpecs, 0, fieldSpecs.length);
//        System.arraycopy(additionalFieldSpecs, 0, mergedFieldSpecs, fieldSpecs.length, additionalFieldSpecs.length);
//        return mergedFieldSpecs;
//    }
}
