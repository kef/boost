package au.net.netstorm.boost.test.automock;

import java.lang.reflect.Field;
import au.net.netstorm.boost.test.atom.DefaultPrimitiveBoxer;
import au.net.netstorm.boost.test.atom.DefaultRandomProvider;
import au.net.netstorm.boost.test.atom.PrimitiveBoxer;
import au.net.netstorm.boost.test.atom.RandomProvider;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.DefaultModifierTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.ModifierTestUtil;

public final class DefaultBoostField implements BoostField {
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final ModifierTestUtil modifier = new DefaultModifierTestUtil();
    private final PrimitiveBoxer primitiveBoxer = new DefaultPrimitiveBoxer();
    private final RandomProvider randomProvider = new DefaultRandomProvider();
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

    public boolean isArray() {
        Class type = field.getType();
        return type.isArray();
    }

    public boolean isPrimitive() {
        Class type = field.getType();
        return primitiveBoxer.isPrimitive(type);
    }

    public boolean isSupportedConcrete() {
        Class type = field.getType();
        return randomProvider.isRandomizable(type);
    }

    public boolean isInterface() {
        Class type = field.getType();
        return type.isInterface();
    }

    public boolean isSynthetic() {
        String fieldName = field.getName();
        return fieldName.contains("$");
    }

    // FIX BREADCRUMB 35593 Should we split this into: canRandomize(), canMock(), canStub()?
    // FIX BREADCRUMB 35593 Rename this if not splitting.
    public boolean isFooable() {
        return isNull() && !isFinal() && !isSynthetic();
    }
}
