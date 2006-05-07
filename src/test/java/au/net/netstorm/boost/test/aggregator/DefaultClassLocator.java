package au.net.netstorm.boost.test.aggregator;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// FIXME: SC043 Rename classes in this package to reflect current naming conventions for test code.
// FIXME: SC043 Ie. TestClassLocator.
// FIXME: SC043 Refactor de-train wrecked code.

final class DefaultClassLocator implements ClassLocator {
    public ClassName[] locate(File root, RegexPattern pattern) {
        List result = new ArrayList();
        locate(root, pattern, result);
        FileComparator comparator = new FileComparator();
        Collections.sort(result, comparator);
        int count = result.size();
        File[] files = new File[count];
        File[] file = (File[]) result.toArray(files);
        return toClassNames(root, file);
    }

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
        return new DefaultClassName(path);
    }

    private void getMatchingClasses(File dir, RegexPattern pattern, List result) {
        String thePattern = pattern.getPattern();
        RegexPattern clsPattern = new RegexPattern(thePattern + ".class");
        RegexFilter filter = new RegexFilter(clsPattern);
        File[] files = dir.listFiles(filter);
        List list = Arrays.asList(files);
        result.addAll(list);
    }

    private void ensureDir(File dir) {
        if (!dir.exists()) throw new IllegalStateException(dir + " does not exist");
        if (!dir.isDirectory()) throw new IllegalStateException(dir + " must be a directory.");
    }

    private File[] getSubdirectories(File dir) {
        DirectoryFilter filter = new DirectoryFilter();
        return dir.listFiles(filter);
    }
}
