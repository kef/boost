package au.net.netstorm.boost.test.aggregator;

import java.io.File;

import au.net.netstorm.boost.primordial.Primordial;

final class TestFileBasedJavaClass extends Primordial implements JavaClass {
    private final String fullyQualifiedClassPath;

    public TestFileBasedJavaClass(File rootDir, File clsFile) {
        String clsAbsolute = clsFile.getAbsolutePath();
        String rootAbsolute = rootDir.getAbsolutePath();
        String path = makeRelative(rootAbsolute, clsAbsolute);
        fullyQualifiedClassPath = slashesToDots(path);
    }

    private String makeRelative(String rootAbsolute, String absolute) {
        int length = rootAbsolute.length();
        return absolute.substring(length);
    }

    public String getFullyQualified() {
        return fullyQualifiedClassPath;
    }

    private String slashesToDots(String path) {
        String deslashed = path.replaceAll("[/\\\\]", ".");
        String noleadingslash = deslashed.substring(1);
        return noleadingslash.replaceAll(".class", "");
    }
}
