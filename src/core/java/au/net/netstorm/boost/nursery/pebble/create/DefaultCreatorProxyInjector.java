package au.net.netstorm.boost.nursery.pebble.create;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultCreatorProxyInjector implements CreatorProxyInjector {
    private EdgeClass edgeClass = new DefaultEdgeClass();
    private EdgeField edgeField = new DefaultEdgeField();
    private CreatorProxySupplier proxySupplier;
    private CreatorFieldFinder fieldFinder;

    public DefaultCreatorProxyInjector(CreatorProxySupplier proxySupplier, CreatorFieldFinder fieldFinder) {
        this.proxySupplier = proxySupplier;
        this.fieldFinder = fieldFinder;
    }

    public void inject(Object ref) {
        CreatorField[] creatorFields = fieldFinder.find(ref);
        for (int i = 0; i < creatorFields.length; i++) {
            CreatorField creatorField = creatorFields[i];
            inject(ref, creatorField);
        }
        // FIX 1665 Call CreatorFieldsFinder.
        // FIX 1665 Use ProxySupplier to get the Object proxy.
        // FIX 1665 Set Object proxy in fields.
        // FIX 1665 Reinstate
    }

    private void inject(Object ref, CreatorField creatorField) {
        Interface type = creatorField.getCreatorInterface();
        proxySupplier.create(type);
        creatorField.getFieldName();
    }

    // FIX 1665 Test drive up and hook in.
/*
    private void spike(Object ref) {
        CreatorField[] creatorFields = fieldFinder.find(ref);
        for (int i = 0; i < creatorFields.length; i++) {
            inject(ref, creatorFields[i]);
        }
    }

    private void inject(Object ref, CreatorField field) {
        Interface type = field.getCreatorType();
        Object proxy = proxySupplier.create(type);
        inject(ref, proxy, field);
    }

    private void inject(Object ref, Object proxy, CreatorField creatorField) {
        String fieldName = creatorField.getFieldName();
        Class cls = ref.getClass();
        Field field = edgeClass.getDeclaredField(cls, fieldName);
        edgeField.set(field, ref, proxy);

    }
*/
}
