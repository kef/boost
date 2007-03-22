package au.net.netstorm.boost.test.automock;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// FIX 1676 Stitch this in.
public final class BoostFieldBuilder implements FieldBuilder {
    public BoostField[] build(Object ref) {
        Field[] fields = getFields(ref);
        List result = new ArrayList();
        for (int i = 0; i < fields.length; i++) {
            add(result, ref, fields[i]);
        }
        return (BoostField[]) result.toArray(new BoostField[]{});
    }

    private Field[] getFields(Object ref) {
        Class cls = ref.getClass();
        return cls.getDeclaredFields();
    }

    private void add(List result, Object ref, Field field) {
        BoostField boostField = new DefaultBoostField(ref, field);
        result.add(boostField);
    }
}
