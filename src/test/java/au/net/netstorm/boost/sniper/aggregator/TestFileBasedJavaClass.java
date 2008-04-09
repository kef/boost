package au.net.netstorm.boost.sniper.aggregator;

import java.io.File;
import au.net.netstorm.boost.bullet.primordial.Primordial;

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
        String deBillGates = path.replaceAll("[/\\\\]", ".");
        String noLeadingSlash = deBillGates.substring(1);
        return noLeadingSlash.replaceAll("\\.class", "");
    }
}
