package au.net.netstorm.boost.nursery.pebble.create;

import au.net.netstorm.boost.edge.java.lang.EdgeClass;

public final class DefaultCreatorProxyInjector implements CreatorProxyInjector {
    private CreatorProxySupplier proxySupplier;
    private EdgeClass edgeClass;
    private CreatorFieldFinder fieldFinder;

    public DefaultCreatorProxyInjector(CreatorProxySupplier creatorProxySupplier, EdgeClass edgeClass) {
        this.proxySupplier = creatorProxySupplier;
        this.edgeClass = edgeClass;
    }

    public void inject(Object ref) {
//        spike(ref);
        // FIX 1665 Reinstate
        // edgeClass.getDeclaredFields(object.getClass());
    }
/*

    private void spike(Object ref) {
        CreatorField[] creatorFields = fieldFinder.find(ref);
        for (int i = 0; i < creatorFields.length; i++) {
            inject(ref, creatorFields[i]);
        }
    }

    private void inject(Object ref, CreatorField field) {
        proxySupplier.create(type);
    }
*/
}
