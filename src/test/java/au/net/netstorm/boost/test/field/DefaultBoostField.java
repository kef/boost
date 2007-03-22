package au.net.netstorm.boost.test.field;

import java.lang.reflect.Field;
import au.net.netstorm.boost.test.atom.DefaultPrimitiveBoxer;
import au.net.netstorm.boost.test.atom.PrimitiveBoxer;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.DefaultModifierTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.ModifierTestUtil;

// FIX 1676 Make local. Leave iface public.
public final class DefaultBoostField implements BoostField {
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final ModifierTestUtil modifier = new DefaultModifierTestUtil();
    private final PrimitiveBoxer primitiveBoxer = new DefaultPrimitiveBoxer();
    private final Object ref;
    private final Field field;

    public DefaultBoostField(Object ref, Field field) {
        this.ref = ref;
        this.field = field;
    }

    // FIX 1676 Remove set/get from here.
    public Object get() {
        return fielder.getInstance(ref, field);
    }

    public void set(Object value) {
        String fieldName = field.getName();
        fielder.setInstance(ref, fieldName, value);
    }

    public boolean isNull() {
        return fielder.getInstance(ref, field) == null;
    }

    public boolean isFinal() {
        return modifier.isFinal(field);
    }

    public boolean isArray() {
        Class type = field.getType();
        return type.isArray();
    }

    public boolean isPrimitive() {
        Class type = field.getType();
        return primitiveBoxer.isPrimitive(type);
    }

    public boolean isInterface() {
        Class type = field.getType();
        return type.isInterface();
    }

    public boolean isSynthetic() {
        String fieldName = field.getName();
        return fieldName.contains("$");
    }

    public String getName() {
        return field.getName();
    }

    public Class getType() {
        return field.getType();
    }

    // FIX 1676 Move this.
    // DEBT CyclomaticComplexity|ReturnCount {
    public boolean isInjectable() {
        if (isArray()) return false;
        if (isSynthetic()) return false;
        if (isFinal()) return false;
        if (isPrimitive()) return true;
        return isNull();
    }
    // } DEBT CyclomaticComplexity|ReturnCount
}
