package au.net.netstorm.boost.pebble.inject.newer.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.pebble.inject.core.InjectorEngine;
import au.net.netstorm.boost.pebble.inject.newer.field.NewerField;
import au.net.netstorm.boost.pebble.inject.newer.field.NewerFieldFinder;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public final class NewerProxyInjectorEngine implements InjectorEngine {
    private EdgeClass edgeClass = new DefaultEdgeClass();
    private EdgeField edgeField = new DefaultEdgeField();
    private NewerProxySupplier proxySupplier;
    private NewerFieldFinder fieldFinder;

    public NewerProxyInjectorEngine(NewerProxySupplier proxySupplier, NewerFieldFinder fieldFinder) {
        this.proxySupplier = proxySupplier;
        this.fieldFinder = fieldFinder;
    }

    public void inject(UnresolvedInstance unresolved) {
        Object ref = unresolved.getRef();
        NewerField[] newerFields = fieldFinder.find(ref);
        inject(ref, newerFields);
    }

    private void inject(Object ref, NewerField[] newerFields) {
        for (int i = 0; i < newerFields.length; i++) {
            inject(ref, newerFields[i]);
        }
    }

    private void inject(Object ref, NewerField field) {
        Interface newerInterface = field.getNewerInterface();
        Implementation instanceImplementation = field.getInstanceImplementation();
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
