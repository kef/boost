package au.net.netstorm.boost.test.field;

import java.lang.reflect.Field;
import au.net.netstorm.boost.test.atom.DefaultPrimitiveBoxer;
import au.net.netstorm.boost.test.atom.PrimitiveBoxer;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.DefaultModifierTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.ModifierTestUtil;

final class DefaultBoostField implements BoostField {
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final ModifierTestUtil modifier = new DefaultModifierTestUtil();
    private final PrimitiveBoxer primitiveBoxer = new DefaultPrimitiveBoxer();
    private final Object ref;
    private final Field field;

    public DefaultBoostField(Object ref, Field field) {
        this.ref = ref;
        this.field = field;
    }

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

    public boolean isStatic() {
        return modifier.isStatic(field);
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

    public boolean isPublic() {
        return modifier.isPublic(field);
    }

    public boolean isProtected() {
        return modifier.isProtected(field);
    }

    public boolean isPrivate() {
        return modifier.isPrivate(field);
    }

    public boolean prefix(String s) {
        String name = getName();
        return name.startsWith(s);
    }

    public boolean is(String s) {
        String name = getName();
        return name.equals(s);
    }

    public String getName() {
        return field.getName();
    }

    public Class getType() {
        return field.getType();
    }

    public Field getField() {
        return field;
    }
}
