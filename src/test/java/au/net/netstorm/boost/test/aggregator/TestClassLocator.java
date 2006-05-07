package au.net.netstorm.boost.test.aggregator;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// FIXME: SC043 Refactor de-train wrecked code.

final class TestClassLocator implements ClassLocator {
    private final Comparator comparator = new TestFileComparator();

    public JavaClass[] locate(File root, RegexPattern pattern) {
        File[] files = sortedDeepLocate(root, pattern);
        return toClassNames(root, files);
    }

    private File[] sortedDeepLocate(File root, RegexPattern pattern) {
        List result = new ArrayList();
        recursiveLocate(root, pattern, result);
        Collections.sort(result, comparator);
        return (File[]) result.toArray(new File[]{});
    }

    private JavaClass[] toClassNames(File root, File[] files) {
        JavaClass[] result = new JavaClass[files.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = getClass(root, files[i]);
        }
        return result;
    }

    private void recursiveLocate(File dir, RegexPattern pattern, List result) {
        ensureDir(dir);
        File[] subdirs = getSubdirectories(dir);
        for (int i = 0; i < subdirs.length; i++) {
            recursiveLocate(subdirs[i], pattern, result);
        }
        getMatchingClasses(dir, pattern, result);
    }

    private File[] getSubdirectories(File dir) {
        DirectoryFilter filter = new DirectoryFilter();
        return dir.listFiles(filter);
    }

    private JavaClass getClass(File root, File file) {
        return new TestFileBasedJavaClass(root, file);
    }

    private void getMatchingClasses(File dir, RegexPattern pattern, List result) {
        String thePattern = pattern.getPattern();
        RegexPattern clsPattern = new TestRegexPattern(thePattern + ".class");
        TestRegexFilter filter = new TestRegexFilter(clsPattern);
        File[] files = dir.listFiles(filter);
        List list = Arrays.asList(files);
        result.addAll(list);
    }

    private void ensureDir(File dir) {
        if (!dir.exists()) barf(dir, " does not exist");
        if (!dir.isDirectory()) barf(dir, " must be a directory.");
    }

    private void barf(File dir, String content) {
        throw new IllegalStateException(dir + content);
    }
}
