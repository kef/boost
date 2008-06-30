package au.net.netstorm.boost.nursery.eight.legged.spider.provider.types;

import au.net.netstorm.boost.scalpel.core.AutoEdger;

public final class EdgeProvider implements Provider {
    private final Class edge;
    AutoEdger edger;

    public EdgeProvider(Class edge) {
        this.edge = edge;
    }

    public Object nu(Object... args) {
        return edger.nu(edge, args);
    }
}
