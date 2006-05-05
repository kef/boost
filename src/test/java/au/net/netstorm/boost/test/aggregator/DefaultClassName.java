package au.net.netstorm.boost.test.aggregator;

// FIXME: SC043 Interface.
// FIXME: SC043 De train wreck.
// FIXME: SC043 Primordial.

final class DefaultClassName implements ClassName {
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

    public String toString() {
        return "ClassName[" + fullyQualifiedClassPath + "]";
    }
}
