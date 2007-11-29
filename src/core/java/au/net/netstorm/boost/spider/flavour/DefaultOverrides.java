package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeSystem;
import au.net.netstorm.boost.edge.java.lang.EdgeSystem;

public class DefaultOverrides implements Overrides {
    private static final String ALLOW_OVERRIDES = "spider.allow.overrides";
    private final EdgeSystem system = new DefaultEdgeSystem();

    public boolean allowed() {
        return system.getProperty(ALLOW_OVERRIDES) != null;
    }
}
