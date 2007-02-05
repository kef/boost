package au.net.netstorm.boost.nursery.pebble.create;

import au.net.netstorm.boost.edge.java.lang.EdgeClass;

public final class DefaultCreatorProxyInjector implements CreatorProxyInjector {
    private CreatorProxySupplier creatorProxySupplier;
    private EdgeClass edgeClass;

    public DefaultCreatorProxyInjector(CreatorProxySupplier creatorProxySupplier, EdgeClass edgeClass) {
        this.creatorProxySupplier = creatorProxySupplier;
        this.edgeClass = edgeClass;
    }

    public void inject(Object object) {
        // FIX 1665 Reinstate
        // edgeClass.getDeclaredFields(object.getClass());
    }
}
