package au.net.netstorm.boost.test.aggregator;

// FIXME: SC506 Interface.
// FIXME: SC506 De train wreck.
// FIXME: SC506 Primordial.
class ClassName {
    private final String fullyQualifiedClassPath;

    public ClassName(String path) {
        fullyQualifiedClassPath = convertSlashes(path);
    }

    private String convertSlashes(String path) {
        return path.replaceAll("[/\\\\]", ".").substring(1).replaceAll(".class", "");
    }

    public String getFullyQualified() {
        return fullyQualifiedClassPath;
    }

    public String toString() {
        return "ClassName[" + fullyQualifiedClassPath + "]";
    }
}
