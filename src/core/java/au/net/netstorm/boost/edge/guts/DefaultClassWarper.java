package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.edge.core.StaticEdge;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.gunge.string.StringTransform;

public final class DefaultClassWarper implements ClassWarper {
    EdgeClass classer;
    StringTransform transformer;
    EdgePackage edges;

    public Class<?> edgeToReal(Class<?> edge) {
        String realName = realName(edge);
        // FIX 2328 need to discuss error handling a bit more - EE or wrap in IAE
        return classer.forName(realName);
    }

    private String realName(Class<?> edge) {
        String prefix = edges.prefix() + ".";
        String name = edge.getName();
        return warpName(edge, prefix, name);
    }

    private String warpName(Class<?> edge, String prefix, String name) {
        String warped = transformer.stripPrefix(name, prefix);
        if (StaticEdge.class.isAssignableFrom(edge)) {
            warped = transformer.stripSuffix(warped, "Static");
        }
        return warped;
    }
}
