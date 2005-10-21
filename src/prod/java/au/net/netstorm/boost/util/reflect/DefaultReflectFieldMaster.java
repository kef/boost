package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import au.net.netstorm.boost.util.introspect.DefaultFieldValueSpec;
import au.net.netstorm.boost.util.introspect.FieldValueSpec;

class DefaultReflectFieldMaster implements ReflectFieldMaster {
    public FieldValueSpec[] getInstanceFields(Object ref) {
        Class cls = ref.getClass();
        return instanceFields(cls.getDeclaredFields(), ref);
    }

    private FieldValueSpec[] instanceFields(Field[] fields, Object ref) {
        List list = new ArrayList();
        for (int i = 0; i < fields.length; i++) addInstanceFields(list, fields[i], ref);
        return (FieldValueSpec[]) list.toArray(new FieldValueSpec[]{});
    }

    private void addInstanceFields(List list, Field field, Object ref) {
        if (isInstance(field)) list.add(createFieldSpec(field, ref));
    }

    private DefaultFieldValueSpec createFieldSpec(Field field, Object ref) {
        String name = field.getName();
        Object value = getFieldValue(field, ref);
        return new DefaultFieldValueSpec(name, value);
    }

    private Object getFieldValue(Field field, Object ref) {
        field.setAccessible(true);
        return ReflectEdge.INSTANCE.get(field, ref);
    }

    private boolean isInstance(Field field) {
        return !Modifier.isStatic(field.getModifiers());
    }
}
