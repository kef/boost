package au.net.netstorm.boost.test.serialize;

public final class DefaultSerializationClaimChecker implements SerializationClaimChecker {
//    private static final String PATH_ROOT = "/";
//    private static final Class<Vocabulary> PRODUCTION_CLASS = Vocabulary.class;
//    private static final String DOT = ".";
//    private static final MarkedAsSerializableClassFilter FILTER_MARKED_AS_SERIALIZABLE = new MarkedAsSerializableClassFilter();
//
//    public void checkSerializationClaim() {
//        File packageRoot = getLocation(PATH_ROOT);
//        Collection<File> allClasses = new RecursiveFileFinder().findFiles(packageRoot, new JavaClassFileFilter());
//        Collection<Class<? extends Serializable>> serializableClasses = getSerializableClasses(packageRoot, allClasses);
//        checkSerializability(serializableClasses);
//    }
//
//    // FIX SC523 Remove excluded classes once all classes serialize
//    private void checkSerializability(Collection<Class<? extends Serializable>> serializables) {
//        for (Class<? extends Serializable> cls : serializables) {
//            if (!excuseFromSerializationCheck(cls)) {
//                SerializationTestUtil.checkSerializability(cls);
//            }
//        }
//    }
//
//    // Note. We can't & don't check the serializability of interfaces.
//    private boolean excuseFromSerializationCheck(Class<? extends Serializable> cls) {
//        Collection<Class<?>> excludedClasses = getExcludedClasses();
//        return excludedClasses.contains(cls) || ClassPropertiesTestUtil.isClassAnInterface(cls);
//    }
//
//    // FIX SC523 Remove excluded classes once all classes serialize properly
//    private Collection<Class<?>> getExcludedClasses() {
//        Collection<Class<?>> excludedClasses = new ArrayList<Class<?>>();
//        excludedClasses.add(GraphImpl.class);
//        excludedClasses.add(LongIndexMem.class);
//        excludedClasses.add(NullaryTuple.class);
//        excludedClasses.add(ConstraintExpression.AllConstraintExpression.class);  // not sure why this doesn't work
//        excludedClasses
//                .add(QueryImpl.class); // not sure why this doesn't work, it references ConstraintExpression.ALL
//        excludedClasses.add(DefaultVariable.class); // implement equals() & hashCode()
//        return excludedClasses;
//    }
//
//    // FIX SC523 Try to remove unchecked cast below.
//    @SuppressWarnings("unchecked")
//    private Collection<Class<? extends Serializable>> getSerializableClasses(File packageRoot, Collection<File> classes) {
//        Collection<Class<? extends Serializable>> serializables = new ArrayList<Class<? extends Serializable>>();
//        for (File file : classes) {
//            Class<?> cls = getClass(packageRoot, file);
//            if (isMarkedAsSerializable(cls)) {
//                serializables.add((Class<? extends Serializable>) cls);
//            }
//        }
//        return serializables;
//    }
//
//    private Class<?> getClass(File packageRoot, File classFile) {
//        String className = getClassName(packageRoot, classFile);
//        return getClassForname(className);
//    }
//
//    private String getClassName(File packageRoot, File cls) {
//        try {
//            String pathWithPackageRemoved = removePackagePrefix(packageRoot.getCanonicalPath(), cls.getCanonicalPath());
//            return replaceFileSeperatorsWithDots(pathWithPackageRemoved);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private Class<?> getClassForname(String className) {
//        try {
//            return Class.forName(className);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private String removePackagePrefix(String packagePath, String fullPath) {
//        return fullPath.substring(packagePath.length(), fullPath.lastIndexOf(DOT));
//    }
//
//    private String replaceFileSeperatorsWithDots(String path) {
//        String separator = File.separator;
//        separator = separator.replaceAll("\\\\", "\\\\\\\\");
//        String name = path.replaceAll(separator, DOT);
//        if (name.startsWith(DOT)) {
//            name = name.substring(1);
//        }
//        return name;
//    }
//
//    private boolean isMarkedAsSerializable(Class<?> cls) {
//        return FILTER_MARKED_AS_SERIALIZABLE.accept(cls);
//    }
//
//    private static File getLocation(String path) {
//        return new File(PRODUCTION_CLASS.getResource(path).getFile());
//    }
}
