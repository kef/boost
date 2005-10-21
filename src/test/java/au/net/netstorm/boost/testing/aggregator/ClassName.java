package au.net.netstorm.boost.testing.aggregator;

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
