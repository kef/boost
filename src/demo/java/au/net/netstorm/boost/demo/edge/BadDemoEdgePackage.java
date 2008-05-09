package au.net.netstorm.boost.demo.edge;

import au.net.netstorm.boost.edge.guts.EdgePackage;

public final class BadDemoEdgePackage implements EdgePackage {
    public String prefix() {
        return "demo.edge.bad";
    }
}
