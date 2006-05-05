package au.net.netstorm.boost.test.aggregator;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// FIXME: SC043 Rename classes in this package to reflect current naming conventions for test code.
// FIXME: SC043 De train wreck.
// FIXME: SC043 Interface.

final class DefaultClassLocator implements ClassLocator {
    public ClassName[] locate(File root, RegexPattern pattern) {
        List result = new ArrayList();
        locate(root, pattern, result);
        Collections.sort(result, new FileComparator());
        File[] file = (File[]) result.toArray(new File[result.size()]);
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
        for (int i = 0; i < result.length; i++) result[i] = getClassName(files[i], root);
        return result;
    }

    private ClassName getClassName(File file, File root) {
        String path = file.getAbsolutePath()
                .substring(root.getAbsolutePath().length());
        return new DefaultClassName(path);
    }

    private void getMatchingClasses(File dir, RegexPattern pattern, List result) {
        RegexPattern clsPattern = new RegexPattern(pattern.getPattern() + ".class");
        File[] files = dir.listFiles(new RegexFilter(clsPattern));
        result.addAll(Arrays.asList(files));
    }

    private void ensureDir(File dir) {
        if (!dir.exists()) throw new IllegalStateException(dir + " does not exist");
        if (!dir.isDirectory()) throw new IllegalStateException(dir + " must be a directory.");
    }

    private File[] getSubdirectories(File dir) {
        return dir.listFiles(new DirectoryFilter());
    }
}
