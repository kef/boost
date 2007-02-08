package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.Field;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultOldCreatorProxyInjector implements OldCreatorProxyInjector {
    private EdgeClass edgeClass = new DefaultEdgeClass();
    private EdgeField edgeField = new DefaultEdgeField();
    private OldCreatorProxySupplier proxySupplier;
    private OldCreatorFieldFinder fieldFinder;

    public DefaultOldCreatorProxyInjector(OldCreatorProxySupplier proxySupplier, OldCreatorFieldFinder fieldFinder) {
        this.proxySupplier = proxySupplier;
        this.fieldFinder = fieldFinder;
    }

    public void inject(Object ref) {
        OldCreatorField[] creatorFields = fieldFinder.find(ref);
        for (int i = 0; i < creatorFields.length; i++) {
            OldCreatorField creatorField = creatorFields[i];
            inject(ref, creatorField);
        }
    }

    private void inject(Object ref, OldCreatorField field) {
        Interface type = field.getCreatorInterface();
        Object proxy = proxySupplier.create(type);
        inject(ref, proxy, field);
    }

    private void inject(Object ref, Object proxy, OldCreatorField creatorField) {
        String fieldName = creatorField.getFieldName();
        Class cls = ref.getClass();
        Field field = edgeClass.getDeclaredField(cls, fieldName);
        field.setAccessible(true);
        edgeField.set(field, ref, proxy);
    }
}
