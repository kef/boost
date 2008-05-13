package au.net.netstorm.boost.demo.edge;

import au.net.netstorm.boost.scalpel.engine.EdgePackage;

public final class BadDemoEdgePackage implements EdgePackage {
    public String prefix() {
        return "demo.edge.bad";
    }
}
