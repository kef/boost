package au.net.netstorm.boost.nursery.eight.legged.spider.core;

import au.net.netstorm.boost.spider.core.Nu;

public final class DefaultNu implements Nu {
    private final NuObjectGraph nuGraph;

    public DefaultNu(NuObjectGraph nuGraph) {
        this.nuGraph = nuGraph;
    }

    public <T> T nu(Class<T> iface, Object... args) {
        // FIX 2394 validate that we are dealing with an interface - will exist in existing code somewhere
        return nuGraph.nu(iface, args);
    }
}
