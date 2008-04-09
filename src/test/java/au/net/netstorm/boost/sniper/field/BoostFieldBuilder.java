package au.net.netstorm.boost.sniper.field;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.util.array.ArrayMaster;
import au.net.netstorm.boost.util.array.DefaultArrayMaster;

public final class BoostFieldBuilder implements FieldBuilder {
    ArrayMaster arrays = new DefaultArrayMaster();

    public BoostField[] build(Object ref) {
        Field[] fields = getFields(ref);
        List<BoostField> result = new ArrayList<BoostField>();
        for (Field field : fields) {
            add(result, ref, field);
        }
        return arrays.toArray(result, BoostField.class);
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
