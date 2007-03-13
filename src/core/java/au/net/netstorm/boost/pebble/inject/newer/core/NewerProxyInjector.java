package au.net.netstorm.boost.pebble.inject.newer.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.pebble.inject.newer.field.NewerField;
import au.net.netstorm.boost.pebble.inject.newer.field.NewerFieldFinder;
import au.net.netstorm.boost.util.type.Interface;

public final class NewerProxyInjector implements Injector {
    private EdgeClass edgeClass = new DefaultEdgeClass();
    private EdgeField edgeField = new DefaultEdgeField();
    private NewerProxySupplier proxySupplier;
    private NewerFieldFinder fieldFinder;

    public NewerProxyInjector(NewerProxySupplier proxySupplier, NewerFieldFinder fieldFinder) {
        this.proxySupplier = proxySupplier;
        this.fieldFinder = fieldFinder;
    }

    public void inject(Object ref) {
        NewerField[] newerFields = fieldFinder.find(ref);
        for (int i = 0; i < newerFields.length; i++) {
            inject(ref, newerFields[i]);
        }
    }

    private void inject(Object ref, NewerField field) {
        Interface newerInterface = field.getNewerInterface();
        Class instanceImplementation = field.getInstanceImplementation();
        Object proxy = proxySupplier.nu(newerInterface, instanceImplementation);
        inject(ref, proxy, field);
    }

    private void inject(Object ref, Object proxy, NewerField newerField) {
        String fieldName = newerField.getFieldName();
        Class cls = ref.getClass();
        Field field = edgeClass.getDeclaredField(cls, fieldName);
        field.setAccessible(true);
        edgeField.set(field, ref, proxy);
    }
}
