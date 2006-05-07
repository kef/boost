package au.net.netstorm.boost.test.aggregator;

import au.net.netstorm.boost.primordial.Primordial;

// FIXME: SC043 Primordial.

final class DefaultClassName extends Primordial implements ClassName {
    private final String fullyQualifiedClassPath;

    public String getFullyQualified() {
        return fullyQualifiedClassPath;
    }

    public DefaultClassName(String path) {
        fullyQualifiedClassPath = convertSlashes(path);
    }

    private String convertSlashes(String path) {
        String deslashed = path.replaceAll("[/\\\\]", ".");
        String noleadingslash = deslashed.substring(1);
        return noleadingslash.replaceAll(".class", "");
    }
}
