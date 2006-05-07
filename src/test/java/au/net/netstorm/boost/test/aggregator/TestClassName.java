package au.net.netstorm.boost.test.aggregator;

import au.net.netstorm.boost.primordial.Primordial;

final class TestClassName extends Primordial implements ClassName {
    private final String fullyQualifiedClassPath;

    public String getFullyQualified() {
        return fullyQualifiedClassPath;
    }

    public TestClassName(String path) {
        fullyQualifiedClassPath = convertSlashes(path);
    }

    private String convertSlashes(String path) {
        String deslashed = path.replaceAll("[/\\\\]", ".");
        String noleadingslash = deslashed.substring(1);
        return noleadingslash.replaceAll(".class", "");
    }
}
