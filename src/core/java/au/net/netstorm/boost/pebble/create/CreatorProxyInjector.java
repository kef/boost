package au.net.netstorm.boost.pebble.create;

import java.lang.reflect.Field;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.pebble.create.field.CreatorField;
import au.net.netstorm.boost.pebble.create.field.CreatorFieldFinder;
import au.net.netstorm.boost.util.type.Interface;

public final class CreatorProxyInjector implements Injector {
    private EdgeClass edgeClass = new DefaultEdgeClass();
    private EdgeField edgeField = new DefaultEdgeField();
    private CreatorProxySupplier proxySupplier;
    private CreatorFieldFinder fieldFinder;

    public CreatorProxyInjector(CreatorProxySupplier proxySupplier, CreatorFieldFinder fieldFinder) {
        this.proxySupplier = proxySupplier;
        this.fieldFinder = fieldFinder;
    }

    public void inject(Object ref) {
        CreatorField[] creatorFields = fieldFinder.find(ref);
        for (int i = 0; i < creatorFields.length; i++) {
            CreatorField creatorField = creatorFields[i];
            inject(ref, creatorField);
        }
    }

    private void inject(Object ref, CreatorField field) {
        Interface creatorInterface = field.getCreatorInterface();
        Class instanceImplementation = field.getInstanceImplementation();
        Object proxy = proxySupplier.create(creatorInterface, instanceImplementation);
        inject(ref, proxy, field);
    }

    private void inject(Object ref, Object proxy, CreatorField creatorField) {
        String fieldName = creatorField.getFieldName();
        Class cls = ref.getClass();
        Field field = edgeClass.getDeclaredField(cls, fieldName);
        field.setAccessible(true);
        edgeField.set(field, ref, proxy);
    }
}
