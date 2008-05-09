package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.edge.java.lang.EdgeClass;

// FIX 2328 come back and tidy this up... looks a little scary for what it does
public final class DefaultClassWarper implements ClassWarper {
    EdgeClass classer;
    EdgePackage edges;

    public Class<?> edgeToReal(Class<?> edge) {
        String prefix = edges.prefix();
        String realName = realName(prefix, edge);
        return realClass(prefix, realName);
    }

    private Class<?> realClass(String prefix, String realName) {
        try {
            return classer.forName(realName);
        } catch (EdgeException e) {
            throw new IllegalArgumentException(
                    "Could not find real class (" + realName + ") ensure it exists in package " + prefix);
        }
    }

    private String realName(String prefix, Class<?> edge) {
        String name = edge.getName();
        validate(prefix, name);
        int start = prefix.length() + 1;
        return name.substring(start);
    }

    private void validate(String prefix, String name) {
        if (!name.startsWith(prefix)) {
            throw new IllegalArgumentException("Edges must be contained in mirrored structure in package: " + prefix);
        }
    }
}
