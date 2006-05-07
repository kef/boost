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

    public ClassName[] locate(File root, RegexPattern pattern) {
        List result = new ArrayList();
        locate(root, pattern, result);
        Collections.sort(result, comparator);
        int count = result.size();
        File[] files = new File[count];
        File[] file = (File[]) result.toArray(files);
        return toClassNames(root, file);
    }

    // FIXME: SC043 Should return an array files?
    private void locate(File dir, RegexPattern pattern, List result) {
        ensureDir(dir);
        File[] subdirs = getSubdirectories(dir);
        for (int i = 0; i < subdirs.length; i++) locate(subdirs[i], pattern, result);
        getMatchingClasses(dir, pattern, result);
    }

    private ClassName[] toClassNames(File root, File[] files) {
        ClassName[] result = new ClassName[files.length];
        for (int i = 0; i < result.length; i++) {
            File file = files[i];
            result[i] = getClassName(file, root);
        }
        return result;
    }

    private ClassName getClassName(File file, File root) {
        String absolute = file.getAbsolutePath();
        String rootAbsolute = root.getAbsolutePath();
        int length = rootAbsolute.length();
        String path = absolute.substring(length);
        return new TestClassName(path);
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

    private File[] getSubdirectories(File dir) {
        DirectoryFilter filter = new DirectoryFilter();
        return dir.listFiles(filter);
    }

    private void barf(File dir, String content) {
        throw new IllegalStateException(dir + content);
    }
}
