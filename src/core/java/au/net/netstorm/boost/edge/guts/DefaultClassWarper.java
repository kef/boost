package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.gunge.string.StringTransform;

public final class DefaultClassWarper implements ClassWarper {
    EdgeClass classer;
    StringTransform transformer;
    EdgePackage edges;

    // FIX 2328 push through staticy instead of using StaticEdge interface
    public Class<?> edgeToReal(Class<?> edge, boolean staticy) {
        String realName = realName(edge, staticy);
        // FIX 2328 need to discuss error handling a bit more - EE or wrap in IAE
        return classer.forName(realName);
    }

    private String realName(Class<?> edge, boolean staticy) {
        String prefix = edges.prefix() + ".";
        String name = edge.getName();
        if (staticy) name = transformer.stripSuffix(name, "Static");
        return transformer.stripPrefix(name, prefix);
    }
}
